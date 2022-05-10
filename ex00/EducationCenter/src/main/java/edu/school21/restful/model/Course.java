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
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "COURSE_X_TEACHER",
            joinColumns = { @JoinColumn(name = "COURSE_ID") },
            inverseJoinColumns = { @JoinColumn(name = "TEACHER_ID") })
    private List<Usr> teachers = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "COURSE_X_STUDENT",
            joinColumns = { @JoinColumn(name = "COURSE_ID") },
            inverseJoinColumns = { @JoinColumn(name = "STUDENT_ID") })
    private List<Usr> students = new ArrayList<>();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return getId().equals(course.getId()) && Objects.equals(getStartDate(), course.getStartDate()) && Objects.equals(getEndDate(), course.getEndDate()) && getName().equals(course.getName()) && Objects.equals(getDescription(), course.getDescription()) && Objects.equals(getTeachers(), course.getTeachers()) && Objects.equals(getStudents(), course.getStudents()) && Objects.equals(getLessons(), course.getLessons());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStartDate(), getEndDate(), getName(), getDescription(), getTeachers(), getStudents(), getLessons());
    }
}
