package com.montezumadev.service.tasks.controller;

import com.montezumadev.service.tasks.dto.TaskRequestDTO;
import com.montezumadev.service.tasks.model.TaskEntity;
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
    public ResponseEntity<TaskEntity> createTask(@RequestBody TaskRequestDTO taskRequest) {
        TaskEntity taskEntity = new TaskEntity(taskRequest);
        TaskEntity createdTask = tasksService.createTask(taskEntity);
        return ResponseEntity.ok(createdTask);
    }

}
