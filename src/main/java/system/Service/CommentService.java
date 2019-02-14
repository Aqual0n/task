package system.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.DAO.CommentDAO;
import system.DAO.CommentDAOClass;
import system.Model.Comment;

import java.util.List;

@Service
public class CommentService implements CommentServiceInterface{

    @Autowired
    CommentDAOClass commentDAO;

    @Override
    public List<Comment> getComments() {
        return commentDAO.getComments();
    }

    @Override
    public void add(Comment comment) {
        commentDAO.add(comment);
    }

    @Override
    public void update(Comment comment) {
        commentDAO.update(comment);
    }

    @Override
    public void delete(Comment comment) {
        commentDAO.delete(comment);
    }

    @Override
    public Comment findById(String id) {
        return commentDAO.findById(id);
    }
}