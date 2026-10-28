package com.example.firstproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity // 1. This class represents a database table
@Table(name = "tasks") // 2. Database table name is tasks
public class Task {

    @Id // 3. Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 4. Database generates the ID

    @NotBlank(message = "Title is required")
    @Size(max = 150, message = "Title must be at most 150 characters")
    private String title; // 5. Task title

    private boolean completed = false; // 6. Default status

    public Task() {
        // 7. Required by JPA
    }

    public Task(String title) {

        this.title = title;
    }

    public Long getId() {
        return id;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}