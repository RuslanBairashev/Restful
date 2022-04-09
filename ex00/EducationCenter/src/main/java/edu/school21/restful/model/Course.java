package edu.school21.restful.model;

import java.util.Date;
import java.util.List;

public class Course {
    private Date startDate;
    private Date endDate;
    private String name;
    private List<Usr> teachers;
    private List<Usr> students;
    private String description;
    private List<Lesson> lessons;

    public Course() {

    }

    public Course(Date startDate, Date endDate, String name, List<Usr> teachers, List<Usr> students, String description, List<Lesson> lessons) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
        this.teachers = teachers;
        this.students = students;
        this.description = description;
        this.lessons = lessons;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Usr> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Usr> teachers) {
        this.teachers = teachers;
    }

    public List<Usr> getStudents() {
        return students;
    }

    public void setStudents(List<Usr> students) {
        this.students = students;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
