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

import system.Model.Comment;

@Service("CommentaryService")
@Transactional
public class CommentService {

    private static String dbName = "comments", dbCollection = "comments";
    private static Logger log = Logger.getLogger(CommentService.class);

    //Получение всех комментариев из БД
    public List getAll() {
        List commentList = new ArrayList();
        DBCollection coll = MongoFactory.getCollection(dbName, dbCollection);

        DBCursor cursor = coll.find();
        while(cursor.hasNext()) {
            DBObject dbObject = cursor.next();

            Comment comment = new Comment();
            comment.setId(dbObject.get("_id").toString());
            comment.setAuthorName(dbObject.get("authorName").toString());
            comment.setCommentaryText(dbObject.get("commentText").toString());
            comment.setCommentaryDate(dbObject.get("commentDate").toString());
            log.debug(comment);
            // Adding the comment details to the list.
            commentList.add(comment);
        }
        log.debug("Итого из БД получено= " + commentList.size() + " комментариев");
        return commentList;
    }

    public Boolean add(Comment comment) {
        boolean output = false;
        Random ran = new Random();
        log.debug("Adding a new commentary to the mongo database; Entered authorName is= " + comment.getAuthorName());
        log.debug("Adding a new commentary to the mongo database; Entered commentaryText is= " + comment.getCommentaryText());
        log.debug("Adding a new commentary to the mongo database; Entered commentaryText is= " + comment.getCommentaryDate());

        try {
            DBCollection coll = MongoFactory.getCollection(dbName, dbCollection);
            Date dateNow = new Date();
            String dateString = dateNow.toString();
            comment.setCommentaryDate(dateString);

            // Создание нового объекта и присвоение деталей.
            BasicDBObject doc = new BasicDBObject();
            doc.put("_id", String.valueOf(ran.nextInt(100)));
            doc.put("authorName", comment.getAuthorName());
            doc.put("commentText", comment.getCommentaryText());
            doc.put("commentDate", comment.getCommentaryDate());

            // Save a new user to the mongo collection.
            coll.insert(doc);
            output = true;
        } catch (Exception e) {
            log.error("An error occurred while saving a new user to the mongo database", e);
        }
        return output;
    }


}
