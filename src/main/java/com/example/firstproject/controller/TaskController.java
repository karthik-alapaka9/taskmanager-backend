
        package com.example.firstproject.controller;

import com.example.firstproject.entity.Task;
import com.example.firstproject.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:5173")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // API 1: Create a task
    @PostMapping
    public ResponseEntity<Task> createTask(
            @Valid @RequestBody Task task) {

        Task savedTask = taskService.createTask(task);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedTask);
    }

    // API 2: Get all tasks
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {

        List<Task> tasks = taskService.getAllTasks();

        return ResponseEntity.ok(tasks);
    }

    // API 3: Update task completion status
    @PatchMapping("/{id}")
    public ResponseEntity<Task> updateTaskCompletion(
            @PathVariable Long id,
            @RequestBody Task updatedTask) {

        Task task = taskService.updateTaskCompletion(
                id,
                updatedTask.isCompleted()
        );

        return ResponseEntity.ok(task);
    }

    // API 4: Delete a task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(
            @PathVariable Long id) {

        taskService.deleteTask(id);

        return ResponseEntity.noContent().build();
    }
}
