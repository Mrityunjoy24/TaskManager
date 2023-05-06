package com.example.taskmanager.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    public TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/all")
    public List<Task> getAllTasks() {
        return taskService.getTaskList();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Integer id) {
        return taskService.getTaskById(id);
    }

    @PostMapping("/new")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task.getName(), task.getDueDate());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Integer id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted");
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Integer id, @RequestBody Task updates) {
        return taskService.updateTask(id, updates);
    }


    @PatchMapping("/{id}")
    public Task patchTask(@PathVariable Integer id, @RequestBody Task updates){
        return taskService.updateTask(id, updates);
    }
}
