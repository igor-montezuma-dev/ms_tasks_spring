package com.montezumadev.service.tasks.service;

import com.montezumadev.service.tasks.dto.NotificationRequestDTO;
import com.montezumadev.service.tasks.model.TasksEntity;
import com.montezumadev.service.tasks.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasksService {

    private final TaskRepository tasksRepository;
    private final NotificationClient notificationClient;

    public TasksService(TaskRepository tasksRepository, NotificationClient notificationClient) {
        this.tasksRepository = tasksRepository;
        this.notificationClient = notificationClient;
    }

    public TasksEntity createTask(TasksEntity tasksEntity) {
        return tasksRepository.save(tasksEntity);
    }

    public void sendNotificationForDueTasks() {
        List<TasksEntity> tasks = tasksRepository.findDueDateTasks();
        tasks.forEach(this::sendNotification);
    }

    private void sendNotification(TasksEntity task) {
        NotificationRequestDTO request = new NotificationRequestDTO(
                String.format("Sua tarefa: %s está prestes a vencer", task.getTitle()),
                task.getEmail()
        );
        notificationClient.sendNotification(request);
        task.setNotified(true);
    }
}
