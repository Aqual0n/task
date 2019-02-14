package system.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.DAO.ArticleDAOClass;
import system.Model.Article;

import java.util.List;

@Service
public class ArticleService implements ArticleServiceInterface{

    @Autowired
    ArticleDAOClass articleDAO;

    @Override
    public List<Article> getArticle() {
        return articleDAO.getArticles();
    }

    @Override
    public void add(Article article) {
        articleDAO.add(article);
    }

    @Override
    public void update(Article article) {
        articleDAO.update(article);
    }

    @Override
    public void delete(Article article) {
        articleDAO.delete(article);
    }

    @Override
    public Article findById(String id) {
        return articleDAO.findById(id);
    }
}
