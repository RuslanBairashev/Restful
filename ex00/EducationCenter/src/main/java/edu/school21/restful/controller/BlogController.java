package edu.school21.restful.controller;

import edu.school21.restful.model.Post;
import edu.school21.restful.model.Usr;
import edu.school21.restful.repo.PostRepository;
import edu.school21.restful.repo.UsrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog345")
    public String blogMain(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("post", posts);
        return "blog-main";
    }

    @GetMapping("/blog345/add")
    public String blogAdd(Model model) {
        return "blog-add";
    }


}
