package edu.school21.restful.model;

import java.sql.Time;

public class Lesson {
    private Time startTime;
    private Time endTime;
    private Usr teacher;
    private enum dayOfWeek {
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY
    }

    public Lesson() {
    }

    public Lesson(Time startTime, Time endTime, Usr teacher) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.teacher = teacher;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Usr getTeacher() {
        return teacher;
    }

    public void setTeacher(Usr teacher) {
        this.teacher = teacher;
    }
}
