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

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public Article(String ArticleTitle, String ArticleText) {
        articleTitle = ArticleTitle;
        articleText = ArticleText;
    }

    public Article() {
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String ArticleTitle) {
        articleTitle = ArticleTitle;
    }

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String ArticleText) {
        articleText = ArticleText;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleTitle='" + articleTitle + '\'' +
                ", articleText='" + articleText + '\'' +
                '}';
    }
}
