package com.montezumadev.service.tasks.dto;

import java.time.LocalDateTime;

public record TaskRequestDTO(
        String title,
        String email,
        LocalDateTime dueDate,
        Boolean notified
) {
}
