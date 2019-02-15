package system.Service;

import system.Model.Article;

import java.io.InputStream;
import java.util.List;

public interface ArticleServiceInterface {
    public List<Article> getArticle();

    public void add(Article article);

    public void update(Article article);

    public void delete(Article article);

    public Article findById(String id);
}
