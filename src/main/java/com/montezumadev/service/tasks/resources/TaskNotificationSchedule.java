package com.montezumadev.service.tasks.resources;

import com.montezumadev.service.tasks.service.NotificationService;
import com.montezumadev.service.tasks.service.TasksService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskNotificationSchedule {

    private final TasksService tasksService;

    public TaskNotificationSchedule(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @Scheduled(fixedRate = 60)
    public void checkAndNotifyTasks() {

        this.tasksService.sendNotificationForDueTasks();
    }
}
