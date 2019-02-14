package system.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Article {
    @Id
    private String _id;

    private String articleTitle;

    private String articleText;

    private String image_id;

    private String articleDate;

    public Article() {
    }

    public Article(String _id, String articleTitle, String articleText, String image_id, String articleDate) {
        this._id = _id;
        this.articleTitle = articleTitle;
        this.articleText = articleText;
        this.image_id = image_id;
        this.articleDate = articleDate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleTitle='" + articleTitle + '\'' +
                ", articleText='" + articleText + '\'' +
                ", articleDate='" + articleDate + '\'' +
                '}';
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public String getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(String articleDate) {
        this.articleDate = articleDate;
    }
}
