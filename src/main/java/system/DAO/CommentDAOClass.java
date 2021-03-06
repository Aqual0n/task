package system.DAO;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.gridfs.GridFSFile;
import com.sun.tools.javac.util.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import system.Model.Comment;

import java.awt.print.Pageable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public class CommentDAOClass implements CommentDAO{

    @Autowired
    MongoTemplate mongoTemplate;

    private static final String CommentsCollectionName = "comment";

    @Override
    public List<Comment> getComments(String article_id) {

        Query query = new Query();

        query.addCriteria(Criteria.where("article_id").is(article_id));

        return mongoTemplate.find(query, Comment.class, CommentsCollectionName);
    }

    @Override
    public Boolean add(Comment comment /*, GridFSFile image*/) {
        boolean output = false;
        //Если коллекция документов нужного нам класса не существует, создаём её
        if (!mongoTemplate.collectionExists(Comment.class)){
            mongoTemplate.createCollection(Comment.class);
        }else{
            Date dateNow = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");

            String dateString = dateFormat.format(dateNow);

            comment.setCommentDate(dateString);

            BasicDBObject doc = new BasicDBObject();
            doc.put("_id", UUID.randomUUID().toString());
            doc.put("authorName", comment.getAuthorName());
            doc.put("commentText", comment.getCommentText());
            doc.put("commentDate", comment.getCommentDate());
            doc.put("article_id", comment.getArticle_id());

            mongoTemplate.insert(doc, CommentsCollectionName);
            output = true;
        }
        return output;
    }

    @Override
    public void update(Comment comment) {
        mongoTemplate.save(comment, CommentsCollectionName);
    }

    @Override
    public void delete(Comment comment) {
        mongoTemplate.remove(comment, CommentsCollectionName);
    }

    @Override
    public Comment findById(String id) {
        return mongoTemplate.findById(id, Comment.class, CommentsCollectionName);
    }
}
