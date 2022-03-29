package com.example.hogwartsnotes;

public class Task {

    private String t_course;
    private String t_task;
    private String d_task;

    public Task() {
    }

    public Task(String t_course, String t_task, String d_task) {
        this.t_course = t_course;
        this.t_task = t_task;
        this.d_task = d_task;
    }

    //getter


    public String getT_course() {
        return t_course;
    }

    public String getT_task() {
        return t_task;
    }

    public String getD_task() {
        return d_task;
    }

    //setter


    public void setT_course(String t_course) {
        this.t_course = t_course;
    }

    public void setT_task(String t_task) {
        this.t_task = t_task;
    }

    public void setD_task(String d_task) {
        this.d_task = d_task;
    }
}
