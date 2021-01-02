package com.example.kkk.model;

import java.io.Serializable;

public class SearchResult implements Serializable {

    private Teacher teacher;
    private Course course;

    public SearchResult(Course course, Teacher teacher) {
        this.teacher = teacher;
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
