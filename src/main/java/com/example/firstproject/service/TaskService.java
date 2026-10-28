
package com.example.firstproject.service;

import com.example.firstproject.entity.Task;
import com.example.firstproject.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Step 1: Create a new task
    public Task createTask(Task task) {
        task.setCompleted(false);
        return taskRepository.save(task);
    }

    // Step 2: Get all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Step 3: Update task completion status
    public Task updateTaskCompletion(Long id, boolean completed) {

        // Find task in the database
        Task task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Task not found with id: " + id));

        // Update completed status
        task.setCompleted(completed);

        // Save updated task in MySQL
        return taskRepository.save(task);
    }
    // Step 4: Delete task
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found with id: " + id);
        }

        taskRepository.deleteById(id);
    }
}
