package edu.school21.restful.controller;

import edu.school21.restful.model.Post;
import edu.school21.restful.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String blogMain(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("post", posts);
        return "blog-main";
    }
}
