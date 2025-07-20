package com.montezumadev.service.tasks.service;

import com.montezumadev.service.tasks.dto.NotificationRequestDTO;
import com.montezumadev.service.tasks.model.TaskEntity;
import com.montezumadev.service.tasks.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TasksService {

    private final TaskRepository tasksRepository;
    private final NotificationService notificationService;

    public TasksService(TaskRepository tasksRepository, NotificationService notificationService) {
        this.tasksRepository = tasksRepository;
        this.notificationService = notificationService;
    }

    public TaskEntity createTask(TaskEntity tasksEntity) {
        return tasksRepository.save(tasksEntity);
    }

    public void sendNotificationForDueTasks() {
        LocalDateTime deadline = LocalDateTime.now().plusDays(1);
        List<TaskEntity> tasks = tasksRepository.findTasksDueWithinDeadline(deadline);
        tasks.forEach(this::sendNotification);
    }

    private void sendNotification(TaskEntity task) {
        NotificationRequestDTO request = new NotificationRequestDTO(
                String.format("Sua tarefa: %s está prestes a vencer", task.getTitle()),
                task.getEmail()
        );
        notificationService.sendNotification(request);
        task.setNotified(true);
    }
}
