package system.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;

@Document
@Entity(name = "Comment")
public class Comment {
    @Id
    private String _id;

    private String authorName;
    private String commentText;

    private String commentDate;

    public Comment() {
    }

    public Comment(String _id, String authorName, String commentText, String commentDate) {
        this._id = _id;
        this.authorName = authorName;
        this.commentText = commentText;
        this.commentDate = commentDate;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }
}
