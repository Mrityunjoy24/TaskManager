package com.example.taskmanager.task;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TaskService {
    List<Task> taskList = new ArrayList<>();
    private int taskId = 1;

    public List<Task> getTaskList() {
        return taskList;
    }

    public Task getTaskById(Integer id) {
        for (Task task : taskList) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        throw new TaskNotFoundException(id);
    }

    public Task createTask(String name, Date dueDate) {
        Task task = new Task();
        task.setId(taskId++);
        task.setName(name);
        task.setDueDate(dueDate);
        task.setCompleted(false);
        taskList.add(task);
        return task;
    }

    public Task updateTask(Integer id, Task updates) {
        Task task = getTaskById(id);
        if (task == null) {
            return null;
        }

        if (updates.getName() != null) {
            task.setName(updates.getName());
        }
        if (updates.getDueDate() != null) {
            task.setDueDate(updates.getDueDate());
        }
        if (updates.isCompleted() != task.isCompleted()) {
            task.setCompleted(updates.isCompleted());
        }

        return task;
    }

    public Task patchTask(Integer id, Boolean completed, Date dueDate) {
        Task task = getTaskById(id);
        if (task == null) {
            return null;
        }

        if (completed != null) {
            task.setCompleted(completed);
        }
        if (dueDate != null) {
            task.setDueDate(dueDate);
        }

        return task;
    }

    public void deleteTask(Integer id) {
        Task task = getTaskById(id);
        if (task != null) {
            taskList.remove(task);
        }
    }


    public static class TaskNotFoundException extends IllegalArgumentException {
        public TaskNotFoundException(Integer id) {
            super("Task with id " + id + " not found");
        }
    }

}
