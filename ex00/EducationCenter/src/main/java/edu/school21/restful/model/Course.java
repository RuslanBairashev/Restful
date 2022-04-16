package edu.school21.restful.model;

import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "COU_G")
    @SequenceGenerator(sequenceName = "COU_G", allocationSize = 1, name = "COU_G")
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    private String name;

    @OneToMany
    private List<Usr> teachers = new ArrayList<>();

    @OneToMany
    private List<Usr> students = new ArrayList<>();

    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Lesson> lessons = new ArrayList<>();

    public Course() {
    }

    public Course(Date startDate, Date endDate, String name, String description) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
