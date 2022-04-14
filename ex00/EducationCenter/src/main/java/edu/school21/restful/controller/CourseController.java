package edu.school21.restful.controller;

import edu.school21.restful.model.Course;
import edu.school21.restful.model.Lesson;
import edu.school21.restful.model.Usr;
import edu.school21.restful.model.UsrRole;
import edu.school21.restful.repo.CourseRepository;
import edu.school21.restful.repo.LessonRepository;
import edu.school21.restful.repo.UsrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

@Controller
public class CourseController {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private UsrRepository usrRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/courses")
    public String getCourses(Model model) {
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
    public String addCourse(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate,
                          @RequestParam String name,
                          @RequestParam String description,
                          Model model) {
        Course course = new Course(startDate, endDate, name, description);
        courseRepository.save(course);
        return "redirect:/courses";
    }

    @GetMapping("/courses/{course-id}")
    public String getCourse(@PathVariable(value = "course-id") Long id, Model model) {
        if (!courseRepository.existsById(id)) {
            return "redirect:/courses";
        }
        Optional<Course> course = courseRepository.findById(id);
        ArrayList<Course> res = new ArrayList<>();
        course.ifPresent(res::add);
        model.addAttribute("course", res);
        return "coursePage";
    }

    @GetMapping("/courses/{course-id}/edit")
    public String editCourse(@PathVariable(value = "course-id") Long id, Model model) {
        if (!courseRepository.existsById(id)) {
            return "redirect:/courses";
        }
        Optional<Course> course = courseRepository.findById(id);
        ArrayList<Course> res = new ArrayList<>();
        course.ifPresent(res::add);
        model.addAttribute("course", res);
        return "courseEdit";
    }

    @PostMapping("/courses/{course-id}/edit")
    public String updateCourse(@PathVariable(value = "course-id") Long id,
                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate,
                               @RequestParam String name,
                               @RequestParam String description,
                             Model model) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException());
        course.setStartDate(startDate);
        course.setEndDate(endDate);
        course.setName(name);
        course.setDescription(description);
        courseRepository.save(course);
        return "redirect:/courses";
    }

    @PostMapping("/courses/{course-id}/delete")
    public String deleteCourse(@PathVariable(value = "course-id") Long id, Model model) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException());
        courseRepository.delete(course);
        return "redirect:/courses";
    }

    @GetMapping("/courses/{course-id}/lessons")
    public String getLessons(@PathVariable(value = "course-id") Long id, Model model) {
        Iterable<Usr> teachers = usrRepository.findAll();
        Iterable<Lesson> lessons = lessonRepository.findAll();
        model.addAttribute("lessons", lessons);
        model.addAttribute("teachers", teachers);
        model.addAttribute("days", Arrays.asList(DayOfWeek.values()));
        return "lessonsList";
    }

    @PostMapping("/courses/{course-id}/lessons")
    public String addLesson(@PathVariable(value = "course-id") Long id,
                            @RequestParam String name,
                            @RequestParam LocalTime startTime,
                            @RequestParam LocalTime endTime,
                            @RequestParam DayOfWeek dayOfWeek,
                            @RequestParam Usr teacher,
                            Model model) {
        Lesson lesson = new Lesson(name, startTime, endTime, dayOfWeek, teacher);
        lessonRepository.save(lesson);
        return "redirect:/courses/{course-id}/lessons";
    }
}