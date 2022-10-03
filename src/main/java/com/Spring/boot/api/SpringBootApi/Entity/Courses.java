package com.Spring.boot.api.SpringBootApi.Entity;

import javax.persistence.*;

@Entity
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int course_Id;

    @Column
    private String course_name;

    @Column
    private String course_description;

    public Courses() {
    }

    public Courses(int course_Id, String course_name, String course_description) {
        this.course_Id = course_Id;
        this.course_name = course_name;
        this.course_description = course_description;
    }

    public int getCourse_Id() {
        return course_Id;
    }

    public void setCourse_Id(int course_Id) {
        this.course_Id = course_Id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "course_Id=" + course_Id +
                ", course_name='" + course_name + '\'' +
                ", course_description='" + course_description + '\'' +
                '}';
    }
}
