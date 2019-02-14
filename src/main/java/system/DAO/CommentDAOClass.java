package system.DAO;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.client.MongoCollection;
import com.mongodb.gridfs.GridFSFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import system.Model.Comment;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public class CommentDAOClass implements CommentDAO{

    @Autowired
    MongoTemplate mongoTemplate;

    private static final String CommentsCollectionName = "comments";

    @Override
    public List<Comment> getComments() {
        return mongoTemplate.findAll(Comment.class, CommentsCollectionName);
    }

    @Override
    public Boolean add(Comment comment /*, GridFSFile image*/) {
        boolean output = false;
        //Если коллекция документов нужного нам класса не существует, создаём её
        if (!mongoTemplate.collectionExists(Comment.class)){
            mongoTemplate.createCollection(Comment.class);
        }else{
            Date dateNow = new Date();
            String dateString = dateNow.toString();
            comment.setCommentDate(dateString);

            BasicDBObject doc = new BasicDBObject();
            doc.put("_id", UUID.randomUUID().toString());
            doc.put("authorName", comment.getAuthorName());
            doc.put("commentText", comment.getCommentText());
            doc.put("commentDate", comment.getCommentDate());

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
