package com.montezumadev.service.tasks.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity(name = "Task")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "task")
public class TasksEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String title;
    private String email;
    private LocalDateTime dueDate;
    private boolean notified;

}
