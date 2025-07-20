package com.montezumadev.service.tasks.repository;

import com.montezumadev.service.tasks.model.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

    @Query("SELECT t FROM Task t WHERE t.dueDate <= :deadline AND t.notified = false")
    List<TaskEntity> findTasksDueWithinDeadline(LocalDateTime deadline);

}
