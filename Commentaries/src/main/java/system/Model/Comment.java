package system.Model;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Comment {
    @Id
    private String id;

    private String AuthorName;
    private String CommentaryText;

    private String CommentaryDate;

    public Comment() {
    }

    public Comment(String authorName, String commentaryText, String commentaryDate) {
        AuthorName = authorName;
        CommentaryText = commentaryText;
        CommentaryDate = commentaryDate;
    }

    public String getCommentaryDate() {
        return CommentaryDate;
    }

    public void setCommentaryDate(String commentaryDate) {
        CommentaryDate = commentaryDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }

    public String getCommentaryText() {
        return CommentaryText;
    }

    public void setCommentaryText(String commentaryText) {
        CommentaryText = commentaryText;
    }

}
