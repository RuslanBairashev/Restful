package edu.school21.restful.controller;

import edu.school21.restful.model.Usr;
import edu.school21.restful.model.UsrRole;
import edu.school21.restful.repo.UsrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

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

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable(value = "id") Long id, Model model) {
        if (!usrRepository.existsById(id)) {
            return "redirect:/users";
        }
        Optional<Usr> usr = usrRepository.findById(id);
        ArrayList<Usr> res = new ArrayList<>();
        usr.ifPresent(res::add);
        model.addAttribute("usr", res);
        return "userPage";
    }

    @GetMapping("/users/{id}/edit")
    public String editUser(@PathVariable(value = "id") Long id, Model model) {
        if (!usrRepository.existsById(id)) {
            return "redirect:/users";
        }
        Optional<Usr> usr = usrRepository.findById(id);
        ArrayList<Usr> res = new ArrayList<>();
        usr.ifPresent(res::add);
        model.addAttribute("usr", res);
        model.addAttribute("roles", Arrays.asList(UsrRole.values()));
        return "userEdit";
    }

    @PostMapping("/users/{id}/edit")
    public String updateUser(@PathVariable(value = "id") Long id,
                             @RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam String login,
                             @RequestParam String password,
                             @RequestParam UsrRole usrRole,
                             Model model) {
        Usr usr = usrRepository.findById(id).orElseThrow(() -> new RuntimeException());
        usr.setFirstName(firstName);
        usr.setLastName(lastName);
        usr.setLogin(login);
        usr.setPassword(password);
        usr.setUsrRole(usrRole);
        usrRepository.save(usr);
        return "redirect:/users";
    }

    @PostMapping("/users/{id}/delete")
    public String deleteUser(@PathVariable(value = "id") Long id, Model model) {
        Usr usr = usrRepository.findById(id).orElseThrow(() -> new RuntimeException());
        usrRepository.delete(usr);
        return "redirect:/users";
    }
}
