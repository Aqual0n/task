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

    public Comment(String id, String AuthorName, String commentaryText, String commentaryDate) {
        _id = id;
        authorName = AuthorName;
        commentText = commentaryText;
        commentDate = commentaryDate;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
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
