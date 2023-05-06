package com.example.taskmanager.task;

import com.example.taskmanager.task.dtos.CreateTaskDTO;
import com.example.taskmanager.task.dtos.responseDtos.CreateTaskResponseDTO;
import com.example.taskmanager.task.dtos.updateTaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<List<CreateTaskResponseDTO>> getAllTasks() {
        List<CreateTaskResponseDTO> createTaskResponseDTOList = new ArrayList<>();
        List<Task> taskList = taskService.getTaskList();
        for (Task task : taskList) {
            createTaskResponseDTOList.add(convertTaskToCreateTaskResponseDTO(task));
        }
        return ResponseEntity.ok(createTaskResponseDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateTaskResponseDTO> getTaskById(@PathVariable Integer id) {
        Task task = taskService.getTaskById(id);
        return ResponseEntity.ok(convertTaskToCreateTaskResponseDTO(task));
    }

    @PostMapping("/new")
    public ResponseEntity<CreateTaskResponseDTO> createTask(@RequestBody CreateTaskDTO task){
        Task task1 =  taskService.createTask(task.getName(), task.getDueDate());
        return ResponseEntity.ok(convertTaskToCreateTaskResponseDTO(task1));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Integer id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreateTaskResponseDTO> updateTask(@PathVariable Integer id, @RequestBody Task updates) {
        Task updatedTask =  taskService.updateTask(id, updates);
        return ResponseEntity.ok(convertTaskToCreateTaskResponseDTO(updatedTask));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CreateTaskResponseDTO> patchTask(@PathVariable Integer id, @RequestBody updateTaskDTO updates){
        Task updatedTask =  taskService.patchTask(id, updates.getCompleted(), updates.getDueDate());
        return ResponseEntity.ok(convertTaskToCreateTaskResponseDTO(updatedTask));
    }

    public CreateTaskResponseDTO convertTaskToCreateTaskResponseDTO(Task task) {
        CreateTaskResponseDTO createTaskResponseDTO = new CreateTaskResponseDTO();
        createTaskResponseDTO.setName(task.getName());
        createTaskResponseDTO.setDueDate(task.getDueDate());
        createTaskResponseDTO.setCompleted(task.isCompleted());
        return createTaskResponseDTO;
    }
}
