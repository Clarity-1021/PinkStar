package com.example.kkk.model;

import java.io.Serializable;

public class Teacher implements Serializable {

    private String teacherName;
    private String teacherCategory;
    private double teacherScore;

    public Teacher(String teacherName, String teacherCategory, double teacherScore) {
        this.teacherName = teacherName;
        this.teacherCategory = teacherCategory;
        this.teacherScore = teacherScore;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherCategory() {
        return teacherCategory;
    }

    public void setTeacherCategory(String teacherCategory) {
        this.teacherCategory = teacherCategory;
    }

    public double getTeacherScore() {
        return teacherScore;
    }

    public void setTeacherScore(double teacherScore) {
        this.teacherScore = teacherScore;
    }
}
