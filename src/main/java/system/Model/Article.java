package system.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Article {
    @Id
    private String id;

    private String ArticleTitle;

    private String ArticleText;

    public Article(String articleTitle, String articleText) {
        ArticleTitle = articleTitle;
        ArticleText = articleText;
    }

    public Article() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleTitle() {
        return ArticleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        ArticleTitle = articleTitle;
    }

    public String getArticleText() {
        return ArticleText;
    }

    public void setArticleText(String articleText) {
        ArticleText = articleText;
    }

    @Override
    public String toString() {
        return "Article{" +
                "ArticleTitle='" + ArticleTitle + '\'' +
                ", ArticleText='" + ArticleText + '\'' +
                '}';
    }
}
