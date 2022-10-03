package com.Spring.boot.api.SpringBootApi.Entity;

import javax.persistence.*;

@Entity
public class Learners {

    @Id
    @GeneratedValue
    private int learner_id;

    @Column
    private String learner_first_name;

    @Column
    private String learner_last_name;

    @Column
    private String learner_email;

    @Column
    private String learner_password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private Courses courses;

    public Learners() {
    }

    public Learners(int learner_id, String learner_first_name, String learner_last_name, String learner_email, String learner_password) {
        this.learner_id = learner_id;
        this.learner_first_name = learner_first_name;
        this.learner_last_name = learner_last_name;
        this.learner_email = learner_email;
        this.learner_password = learner_password;
    }

    public Learners(int learner_id, String learner_first_name, String learner_last_name, String learner_email, String learner_password, Courses courses) {
        this.learner_id = learner_id;
        this.learner_first_name = learner_first_name;
        this.learner_last_name = learner_last_name;
        this.learner_email = learner_email;
        this.learner_password = learner_password;
        this.courses = courses;
    }

    public int getLearner_id() {
        return learner_id;
    }

    public void setLearner_id(int learner_id) {
        this.learner_id = learner_id;
    }

    public String getLearner_first_name() {
        return learner_first_name;
    }

    public void setLearner_first_name(String learner_first_name) {
        this.learner_first_name = learner_first_name;
    }

    public String getLearner_last_name() {
        return learner_last_name;
    }

    public void setLearner_last_name(String learner_last_name) {
        this.learner_last_name = learner_last_name;
    }

    public String getLearner_email() {
        return learner_email;
    }

    public void setLearner_email(String learner_email) {
        this.learner_email = learner_email;
    }

    public String getLearner_password() {
        return learner_password;
    }

    public void setLearner_password(String learner_password) {
        this.learner_password = learner_password;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    public void setCourse(Courses course) {
        this.courses = course;
    }

    @Override
    public String toString() {
        return "Learners{" +
                "learner_id=" + learner_id +
                ", learner_first_name='" + learner_first_name + '\'' +
                ", learner_last_name='" + learner_last_name + '\'' +
                ", learner_email='" + learner_email + '\'' +
                ", learner_password='" + learner_password + '\'' +
                ", courses=" + courses +
                '}';
    }
}
