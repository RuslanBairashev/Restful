package edu.school21.restful.controller;

import edu.school21.restful.model.Usr;
import edu.school21.restful.model.UsrRole;
import edu.school21.restful.repo.UsrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class UserController {

    @Autowired
    private UsrRepository usrRepository;

    @GetMapping("/users")
    public String getUsers(Model model) {
        Iterable<Usr> usrs = usrRepository.findAll();
        model.addAttribute("users", usrs);
        model.addAttribute("roles", Arrays.asList(UsrRole.values()));
        return "usersList";
    }

    @PostMapping("/users")
    public String addUser(@RequestParam String firstName,
                              @RequestParam String lastName,
                              @RequestParam String login,
                              @RequestParam String password,
                              @RequestParam UsrRole usrRole,
                              Model model) {
        Usr usr = new Usr(firstName, lastName, login, password, usrRole);
        usrRepository.save(usr);
        return "redirect:/users";
    }

    @GetMapping("/blog")
    public String blogMain(Model model) {
        Iterable<Usr> usrs = usrRepository.findAll();
        model.addAttribute("usr", usrs);
        return "index";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model) {
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String firstName,
                              @RequestParam String lastName,
                              @RequestParam String login,
                              @RequestParam String password,
                              @RequestParam UsrRole usrRole,
                              Model model) {
        Usr usr = new Usr(firstName, lastName, login, password, usrRole);
        usrRepository.save(usr);
        return "redirect:/blog";
    }
}
