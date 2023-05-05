package com.example.taskmanager.task;

import java.util.Date;

public class Task {
    private int id;
    private String name;
    private Date dueDate;
    private boolean completed;
    public Task() {

    }
    public Task(int id, String name, Date dueDate, boolean completed) {
        this.id = id;
        this.name = name;
        this.dueDate = dueDate;
        this.completed = completed;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
