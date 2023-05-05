package com.example.taskmanager.task.dtos;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CreateTaskDTO {
    private String name;
    private String dueDate;

    public CreateTaskDTO() {

    }

    public CreateTaskDTO(String name, String dueDate) {
        this.name = name;
        this.dueDate = dueDate;
    }
}
