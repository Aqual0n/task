package system.DAO;

import com.mongodb.BasicDBObject;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Repository;
import system.Model.Article;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import com.mongodb.client.gridfs.model.GridFSFile;

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

        List<Article> articles = mongoTemplate.findAll(Article.class, ArticleCollectionName);



//        for (int i = 0; i < articles.size(); i++) {
//            Query query = new Query();
//            query.addCriteria(Criteria.where("filename").is(articles.get(i).getImage_id()));
//
//            GridFSFile image = gridFsTemplate.findOne(query);
//
//
//            GridFsResource fileImage = new GridFsResource(image);
//        }


        return articles;
    }

    @Override
    public Boolean add(Article article, InputStream image) {
        boolean output = false;
        //Если коллекция документов нужного нам класса не существует, создаём её
        if (!mongoTemplate.collectionExists(Article.class)){
            mongoTemplate.createCollection(Article.class);
        }else{

            Date dateNow = new Date();

            String dateString = dateNow.toString();
            article.setArticleDate(dateString);

            String image_id = UUID.randomUUID().toString();

            BasicDBObject doc = new BasicDBObject();
            doc.put("_id", UUID.randomUUID().toString());
            doc.put("articleTitle", article.getArticleTitle());
            doc.put("articleText", article.getArticleText());
            doc.put("image_id", image_id);
            doc.put("articleDate", article.getArticleDate());

            gridFsTemplate.store(image, image_id);

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
