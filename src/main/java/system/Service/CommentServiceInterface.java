package system.Service;

import com.mongodb.BasicDBObject;
import system.Model.Comment;

import java.util.List;

public interface CommentServiceInterface {

    public List<Comment> getComments();

    public void add(Comment comment);

    public void update(Comment comment);

    public void delete(Comment comment);

    public Comment findById(String id);
}
