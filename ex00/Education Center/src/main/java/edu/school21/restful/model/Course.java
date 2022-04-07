package edu.school21.restful.model;

import java.util.Date;
import java.util.List;

public class Course {
    private Date startDate;
    private Date endDate;
    private String name;
    private List<User> teachers;
    private List<User> students;
    private String description;
    private List<Lesson> lessons;
}
