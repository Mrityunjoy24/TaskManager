package com.example.taskmanager.task.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class CreateTaskDTO {
    private String name;
    private Date dueDate;
}
