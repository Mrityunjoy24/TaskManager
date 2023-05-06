package com.example.taskmanager.task.dtos;

import java.util.Date;
import lombok.Data;

@Data
public class updateTaskDTO {
    private Boolean completed;
    private Date dueDate;
}
