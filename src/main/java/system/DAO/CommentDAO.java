package system.DAO;

import com.mongodb.BasicDBObject;
import org.springframework.stereotype.Repository;
import system.Model.Comment;

import java.util.List;

@Repository
public interface CommentDAO {
    public List<Comment> getComments();

    public Boolean add(Comment comment);

    public void update(Comment comment);

    public void delete(Comment comment);

    public Comment findById(String id);

}

