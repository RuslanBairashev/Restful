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
import java.util.*;

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
        Iterable<Lesson> lessons = lessonRepository.findAll();//получать только для course-id
        model.addAttribute("courseid", id);
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
        if (!courseRepository.existsById(id)) {
            return "redirect:/courses";
        }
        Optional<Course> course = courseRepository.findById(id);
        ArrayList<Course> res = new ArrayList<>();
        course.ifPresent(res::add);
        model.addAttribute("course", res);
        Lesson lesson = new Lesson(name, startTime, endTime, dayOfWeek, teacher, course.get());
        //res.get(0).getLessons().add(lesson);
        lessonRepository.save(lesson);
        return "redirect:/courses/{course-id}/lessons";
    }

    @GetMapping("/courses/{course-id}/lessons/{lesson-id}")
    public String editLesson(@PathVariable(value = "lesson-id") Long lid,
                             @PathVariable(value = "course-id") Long id, Model model) {
        if (!courseRepository.existsById(id)) {
            return "redirect:/courses/{course-id}/lessons";
        }
        Optional<Lesson> lesson = lessonRepository.findById(lid);
        ArrayList<Lesson> res = new ArrayList<>();
        lesson.ifPresent(res::add);
        model.addAttribute("lesson", res);
        Iterable<Usr> teachers = usrRepository.findAll();
        model.addAttribute("teachers", teachers);
        model.addAttribute("days", Arrays.asList(DayOfWeek.values()));
        return "lessonEdit";
    }

    @PostMapping("/courses/{course-id}/lessons/{lesson-id}")
    public String updateLesson(@PathVariable(value = "lesson-id") Long lid,
                               @PathVariable(value = "course-id") Long id,
                               @RequestParam String name,
                               @RequestParam LocalTime startTime,
                               @RequestParam LocalTime endTime,
                               @RequestParam DayOfWeek dayOfWeek,
                               @RequestParam Usr teacher,
                               Model model) {
        Lesson lesson = lessonRepository.findById(lid).orElseThrow(() -> new RuntimeException());
        lesson.setName(name);
        lesson.setStartTime(startTime);
        lesson.setEndTime(endTime);
        lesson.setDayOfWeek(dayOfWeek);
        lesson.setTeacher(teacher);
        lessonRepository.save(lesson);
        return "redirect:/courses/{course-id}/lessons";
    }

    @PostMapping("/courses/{course-id}/delete/{lesson-id}")
    public String deleteLesson(@PathVariable(value = "course-id") Long id,
                               @PathVariable(value = "lesson-id") Long lid, Model model) {
        Lesson lesson = lessonRepository.findById(lid).orElseThrow(() -> new RuntimeException());
        lessonRepository.delete(lesson);
        return "redirect:/courses/{course-id}/lessons";
    }

    @GetMapping("/courses/{course-id}/students")
    public String getUsers(@PathVariable(value = "course-id") Long id, Model model) {
        Iterable<Usr> usrs = usrRepository.findAll();
        model.addAttribute("users", usrs);
        model.addAttribute("roles", Arrays.asList(UsrRole.values()));
        return "usersOfCourseList";
    }

    @PostMapping("/courses/{course-id}/students")
    public String addUsers(@PathVariable(value = "course-id") Long id,
                           @RequestParam Usr usr, Model model) {
        Iterable<Usr> usrs = usrRepository.findAll();
        model.addAttribute("users", usrs);
//        Optional<Course> course = courseRepository.findById(id);
//        ArrayList<Course> res = new ArrayList<>();
//        course.ifPresent(res::add);
//        model.addAttribute("course", res);
        //res.get(0).getStudents().add(usr);
        return "usersList";
    }
}
