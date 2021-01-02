package com.example.kkk.model;

import java.io.Serializable;

public class Course implements Serializable {

    private String courseName;
    private String teacherName;
    private String courseCategory;
    private double teacherScore;
    private double chorseScore;

    public Course(String courseName, String courseCategory, String teacherName, double teacherScore, double courseScore) {
        this.courseName = courseName;
        this.courseCategory = courseCategory;
        this.teacherName = teacherName;
        this.teacherScore = teacherScore;
        this.chorseScore = courseScore;
    }

    public void setTeacherScore(double teacherScore) {
        this.teacherScore = teacherScore;
    }

    public double getChorseScore() {
        return chorseScore;
    }

    public void setChorseScore(double chorseScore) {
        this.chorseScore = chorseScore;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getCourseCategory() {
        return courseCategory;
    }

    public void setCourseCategory(String courseCategory) {
        this.courseCategory = courseCategory;
    }

    public double getTeacherScore() {
        return teacherScore;
    }

    public String getTeacherScoreByAll() {
        return teacherScore + " / 5.0";
    }

    public void setTeacherScore(int teacherScore) {
        this.teacherScore = teacherScore;
    }
}
