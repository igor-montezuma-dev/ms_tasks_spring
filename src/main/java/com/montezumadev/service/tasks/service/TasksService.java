package com.montezumadev.service.tasks.service;

import com.montezumadev.service.tasks.model.TasksEntity;
import com.montezumadev.service.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TasksService {

    private final TaskRepository tasksRepository;

    public TasksService(TaskRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }


    public TasksEntity createTask(TasksEntity tasksEntity) {

        return tasksRepository.save(tasksEntity);
    }
}
