package system.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.DAO.MongoFactory;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import system.Model.Article;


@Service("ArticleService")
@Transactional
public class ArticleService {

    private static String dbName = "comments", dbCollection = "articles";
    private static Logger log = Logger.getLogger(CommentService.class);

    public List getAll() {

        List articleList = new ArrayList();
        DBCollection coll = MongoFactory.getCollection(dbName, dbCollection);

        DBCursor cursor = coll.find();
        while(cursor.hasNext()) {
            DBObject dbObject = cursor.next();

            Article article = new Article();
            article.setId(dbObject.get("_id").toString());
            article.setArticleTitle(dbObject.get("articleTitle").toString());
            article.setArticleText(dbObject.get("articleText").toString());
            log.debug(article);
            // Adding the comment details to the list.
            articleList.add(article);
        }
        log.debug("Итого из БД получено= " + articleList.size() + " статей");
        return articleList;
    }

    public Boolean add(Article comment) {
        boolean output = false;
        Random ran = new Random();

        try {
            DBCollection coll = MongoFactory.getCollection(dbName, dbCollection);

            // Создание нового объекта и присвоение деталей.
            BasicDBObject doc = new BasicDBObject();
            doc.put("_id", String.valueOf(ran.nextInt(100)));
            doc.put("articleTitle", comment.getArticleTitle());
            doc.put("articleText", comment.getArticleText());

            // Save a new user to the mongo collection.
            coll.insert(doc);
            output = true;
        } catch (Exception e) {
            log.error("An error occurred while saving a new user to the mongo database", e);
        }
        return output;


    }
}
