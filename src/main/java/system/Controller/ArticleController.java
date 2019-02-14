package system.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import system.Model.Article;
import system.Service.ArticleService;

import java.io.File;

@Controller
@RequestMapping("/")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/new-article", method = RequestMethod.GET)
    public ModelAndView showArticlePage() {
        ModelAndView model = new ModelAndView("/blog/new-article");
        //model.addObject("articlesList", articleService.getArticle());
        model.setViewName("new-article");
        return model;
    }

    @RequestMapping(value = "/new-article/add", method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView addArticle(@ModelAttribute("articleFromServer") Article article){
        ModelAndView model = new ModelAndView("/blog/new-article/add");

        model.setViewName("added-article-message");
        articleService.add(article);
        return model;
    }
}
