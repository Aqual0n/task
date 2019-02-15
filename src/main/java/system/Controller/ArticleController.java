package system.Controller;

import com.mongodb.client.gridfs.model.GridFSFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Autowired
    private GridFsTemplate gridFsTemplate;

    //Это должно выводить список всез статей на главную
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getArticles() {
        ModelAndView model = new ModelAndView("/blog/new-article");
        model.addObject("articleList", articleService.getArticle());
        model.setViewName("index");
        return model;
    }

    @GetMapping("/resources/img/article-images/{imageName}")
    public ResponseEntity<InputStreamResource> getImage(@PathVariable(name = "imageName") String imageName, Model model) throws IOException {
        GridFSFile gridFSFile = gridFsTemplate.findOne(new Query(Criteria.where("filename").is(imageName)));
        GridFsResource gridFsResource = gridFsTemplate.getResource(gridFSFile.getFilename());


        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(gridFsResource.getContentType()))
                .body(new InputStreamResource(gridFsResource.getInputStream()));
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

            String imageId = UUID.randomUUID().toString();
            gridFsTemplate.store(articleImage, imageId, file.getContentType());

            article.setImage_id(imageId);

        }catch (Exception r)
        {
            model.setViewName("new-article");
            return model;
        }


        articleService.add(article);
        return model;
    }
}
