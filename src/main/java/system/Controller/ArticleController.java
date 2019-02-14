package system.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import system.Model.Article;
import system.Service.ArticleService;

import java.io.*;

@Controller
@RequestMapping("/")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    //Это должно выводить список всез статей на главную
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ModelAndView getArticles() {
//        ModelAndView model = new ModelAndView("/blog/new-article");
//        model.addObject("articleList", articleService.getArticle());
//        model.setViewName("index");
//        return model;
//    }


    @RequestMapping(value = "/new-article", method = RequestMethod.GET)
    public ModelAndView showArticlePage() {
        ModelAndView model = new ModelAndView("/blog/new-article");
        //model.addObject("articlesList", articleService.getArticle());
        model.setViewName("new-article");
        return model;
    }

    @RequestMapping(value = "/new-article/add", method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView addArticle(@ModelAttribute("articleFromServer") Article article/*,
                            @RequestParam("articleImage") MultipartFile image,
                            @RequestParam("articleTitle") String articleName*/){
        ModelAndView model = new ModelAndView("/blog/new-article/add");
        //ModelAndView errorModel = new ModelAndView("/blog/new-article");


//       byte[] bytes = image.getBytes();
//       BufferedOutputStream stream =
//          new BufferedOutputStream(new FileOutputStream(new File(articleName + "-uploaded")));
//       stream.write(bytes);
//       stream.close();
//
//            InputStream inputStream = new FileInputStream(articleName + "-uploaded");
//
//
//
//
        model.setViewName("added-article-message");
        articleService.add(article);
        return model;
    }
}
