package system.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import system.Model.Comment;
import system.Service.CommentService;

import java.util.List;

@Controller
@RequestMapping("/article")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/show-article", method = RequestMethod.GET)
    public ModelAndView getAllComments() {
        ModelAndView model = new ModelAndView("article/show-article");
        model.addObject("commentList", commentService.getAll());
        model.setViewName("article");
        return model;
    }

    @RequestMapping(value = "/show-articlet", method = RequestMethod.GET)
    public ModelAndView receiveComment(){
        ModelAndView commentModelAndView = new ModelAndView();
        commentModelAndView.addObject("commentFromServer", new Comment());

        return commentModelAndView;
    }
    @RequestMapping(value = "/add-comment", method = RequestMethod.GET)
    public @ResponseBody String addComment(@ModelAttribute("commentFromServer") Comment commentary){
        commentService.add(commentary);
        return "redirect:/article/show-article";
    }

}
