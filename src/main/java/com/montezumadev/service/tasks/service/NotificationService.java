package com.montezumadev.service.tasks.service;

import com.montezumadev.service.tasks.dto.NotificationRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "service-notification")

public interface NotificationService {

    @PostMapping("/notification")
    void sendNotification(@RequestBody NotificationRequestDTO request);
}
