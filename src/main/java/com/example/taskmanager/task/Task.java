package com.example.taskmanager.task;

import lombok.Data;

import java.util.Date;

@Data
public class Task {
    private Integer id;
    private String name;
    private Date dueDate;
    private boolean completed;
}
