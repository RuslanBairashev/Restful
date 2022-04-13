package edu.school21.restful.model;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "LES_G")
    private Long id;

    private LocalTime startTime;
    private LocalTime endTime;
    private DayOfWeek dayOfWeek;

    @ManyToOne //manyLesson to oneTeacher
    private Usr teacher;

    public Lesson() {
    }

    public Lesson(LocalTime startTime, LocalTime endTime, DayOfWeek dayOfWeek, Usr teacher) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayOfWeek = dayOfWeek;
        this.teacher = teacher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Usr getTeacher() {
        return teacher;
    }

    public void setTeacher(Usr teacher) {
        this.teacher = teacher;
    }
}
