package system.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import system.Model.Article;
import system.Service.ArticleService;
import system.Service.CommentService;

import java.io.*;
import java.util.UUID;

@Controller
@RequestMapping("/")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentService commentService;

    //Это должно выводить список всез статей на главную
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getArticles() {
        ModelAndView model = new ModelAndView("/blog/new-article");
        model.addObject("articleList", articleService.getArticle());
        model.setViewName("index");
        return model;
    }

    @RequestMapping(value = "/article/show-article/{_id}", method = RequestMethod.GET)
    public ModelAndView getArticle(@PathVariable("_id") String articleId) {
        ModelAndView model = new ModelAndView("article/show-article/"+articleId);
        model.addObject("commentList", commentService.getComments(articleId));
        model.addObject("articleToJsp", articleService.findById(articleId));
        model.setViewName("article");
        return model;
    }


    @RequestMapping(value = "/new-article", method = RequestMethod.GET)
    public ModelAndView showArticlePage() {
        ModelAndView model = new ModelAndView("/blog/new-article");
        model.setViewName("new-article");
        return model;
    }

//    Разобраться с кодировкой
    @RequestMapping(value = "/new-article/add", method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView addArticle(@ModelAttribute("articleFromServer") Article article,
                            @RequestParam("articleImage") MultipartFile file){
        ModelAndView model = new ModelAndView("/blog/new-article/add");
        model.setViewName("added-article-message");

        InputStream articleImage = null;

        try {
            articleImage = file.getInputStream();
        }catch (Exception r)
        {
            model.setViewName("new-article");
            return model;
        }


        articleService.add(article, articleImage);
        return model;
    }
}
