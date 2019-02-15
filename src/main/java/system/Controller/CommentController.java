package system.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import system.Model.Comment;
import system.Service.CommentService;

import java.util.List;

@Controller
@RequestMapping("/article")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/{_id}/add-comment", method = RequestMethod.GET)
    public @ResponseBody String addComment(@ModelAttribute("commentFromServer") Comment commentary,
                                           @PathVariable("_id") String articleId){
        commentary.setArticle_id(articleId);
        commentService.add(commentary);
        return "redirect:/article/show-article";
    }

}
