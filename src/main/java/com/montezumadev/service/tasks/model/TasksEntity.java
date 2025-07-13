package com.montezumadev.service.tasks.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TasksEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String title;
    private LocalDateTime dueDate;
    private boolean notified;

}
