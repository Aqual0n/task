package system.DAO;

import org.springframework.stereotype.Repository;
import system.Model.Article;

import java.io.InputStream;
import java.util.List;

@Repository
public interface ArticleDao {
    public List<Article> getArticles();

    public Boolean add(Article article);

    public void update(Article article);

    public void delete(Article article);

    public Article findById(String id);
}
