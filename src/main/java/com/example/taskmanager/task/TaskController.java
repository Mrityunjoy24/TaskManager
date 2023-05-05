package com.example.taskmanager.task;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    List<Task> taskList = new ArrayList<>();
    HashMap<Integer, Task> taskMap = new HashMap<>();
    private int idCounter = 1;
    @GetMapping("/all")

    public List<Task> getAllTasks() {
        return taskList;
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Integer id) {
        return taskMap.get(id);
    }

    @PostMapping("/new")
    public Task createTask(@RequestBody Task task) {
        task.setId(idCounter++);
        taskList.add(task);
        taskMap.put(task.getId(), task);
        return task;
    }
}
