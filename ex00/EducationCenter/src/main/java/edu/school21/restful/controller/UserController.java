package edu.school21.restful.controller;

import edu.school21.restful.dao.UserDAO;
import edu.school21.restful.model.Usr;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Api(description = "test")
public class UserController {

    private final UserDAO userDAO;

    @Autowired
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping
    @ApiOperation("test1")
    public String index(Model model) {
        //model.addAttribute("users", userDAO.index());
        return "users/index";
    }

    @GetMapping("/new")
    @ApiOperation("test2")
    public String newUser(@ModelAttribute("usr") Usr usr) {
        return "users/new";
    }
}
