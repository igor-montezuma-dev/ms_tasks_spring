package com.montezumadev.service.tasks.controller;

import com.montezumadev.service.tasks.model.TasksEntity;
import com.montezumadev.service.tasks.service.TasksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private final TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @PostMapping
    public ResponseEntity<TasksEntity> createTask(@RequestBody TasksEntity tasksEntity) {
        TasksEntity createdTask = tasksService.createTask(tasksEntity);
        return ResponseEntity.ok(createdTask);
    }

}
