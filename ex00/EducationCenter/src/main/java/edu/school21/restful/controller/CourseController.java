package edu.school21.restful.controller;

import edu.school21.restful.model.Course;
import edu.school21.restful.model.Lesson;
import edu.school21.restful.model.Usr;
import edu.school21.restful.repo.CourseRepository;
import edu.school21.restful.repo.LessonRepository;
import edu.school21.restful.repo.UsrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;

@Controller
public class CourseController {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private UsrRepository usrRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/courses")
    public String getUsers(Model model) {
        Iterable<Usr> teachers = usrRepository.findAll();
        Iterable<Usr> students = usrRepository.findAll();
        Iterable<Lesson> lessons = lessonRepository.findAll();
        Iterable<Course> courses = courseRepository.findAll();
        model.addAttribute("lessons", lessons);
        model.addAttribute("teachers", teachers);
        model.addAttribute("students", students);
        model.addAttribute("courses", courses);
        return "coursesList";
    }

    @PostMapping("/courses")
    public String addUser(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate,
                          @RequestParam String name,
                          @RequestParam String description,
                          Model model) {
        Course course = new Course(startDate, endDate, name, description);
        courseRepository.save(course);
        return "redirect:/courses";
    }
}
