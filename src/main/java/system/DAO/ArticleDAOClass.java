package system.DAO;

import com.mongodb.BasicDBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Repository;
import system.Model.Article;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public class ArticleDAOClass implements ArticleDao {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    GridFsTemplate gridFsTemplate;

    private static final String ArticleCollectionName = "article";
    private static final String ImageCollectionName = "images";

    @Override
    public List<Article> getArticles() {
        return mongoTemplate.findAll(Article.class, ArticleCollectionName);
    }

    @Override
    public Boolean add(Article article) {
        boolean output = false;
        //Если коллекция документов нужного нам класса не существует, создаём её
        if (!mongoTemplate.collectionExists(Article.class)){
            mongoTemplate.createCollection(Article.class);
        }else{

            Date dateNow = new Date();

            String dateString = dateNow.toString();
            article.setArticleDate(dateString);

            BasicDBObject doc = new BasicDBObject();
            doc.put("_id", UUID.randomUUID().toString());
            doc.put("articleTitle", article.getArticleTitle());
            doc.put("articleText", article.getArticleText());
            doc.put("image_id", UUID.randomUUID().toString());
            doc.put("articleDate", article.getArticleDate());

            mongoTemplate.insert(doc, ArticleCollectionName);

            //gridFsTemplate.
            output = true;
        }
        return output;
    }

    @Override
    public void update(Article article) {
        mongoTemplate.save(article, ArticleCollectionName);
    }

    @Override
    public void delete(Article article) {
        mongoTemplate.remove(article, ArticleCollectionName);
    }

    @Override
    public Article findById(String id) {
        return mongoTemplate.findById(id, Article.class, ArticleCollectionName);
    }
}
