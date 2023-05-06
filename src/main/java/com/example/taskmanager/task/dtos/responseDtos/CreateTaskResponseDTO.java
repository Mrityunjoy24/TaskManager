package com.example.taskmanager.task.dtos.responseDtos;

import lombok.Data;

import java.util.Date;

@Data
public class CreateTaskResponseDTO {
    private String name;
    private Date dueDate;
    private boolean completed;
}
