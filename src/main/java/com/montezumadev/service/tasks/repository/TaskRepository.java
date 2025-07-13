package com.montezumadev.service.tasks.repository;

import com.montezumadev.service.tasks.model.TasksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TasksEntity, Long> {
}
