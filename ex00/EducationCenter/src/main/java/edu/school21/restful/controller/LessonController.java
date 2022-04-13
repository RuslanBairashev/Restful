package edu.school21.restful.controller;

import edu.school21.restful.model.Lesson;
import edu.school21.restful.model.Usr;
import edu.school21.restful.model.UsrRole;
import edu.school21.restful.repo.LessonRepository;
import edu.school21.restful.repo.UsrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.ManyToOne;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Arrays;

@Controller
public class LessonController {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private UsrRepository usrRepository;

    @GetMapping("/lessons")
    public String getUsers(Model model) {
        Iterable<Usr> teachers = usrRepository.findAll();
        Iterable<Lesson> lessons = lessonRepository.findAll();
        model.addAttribute("lessons", lessons);
        model.addAttribute("teachers", teachers);
        model.addAttribute("days", Arrays.asList(DayOfWeek.values()));
        return "lessonsList";
    }

    @PostMapping("/lessons")
    public String addUser(@RequestParam LocalTime startTime,
                              @RequestParam LocalTime endTime,
                              @RequestParam DayOfWeek dayOfWeek,
                              @RequestParam Usr teacher,
                              Model model) {
        Lesson lesson = new Lesson(startTime, endTime, dayOfWeek, teacher);
        lessonRepository.save(lesson);
        return "redirect:/lessons";
    }
}
