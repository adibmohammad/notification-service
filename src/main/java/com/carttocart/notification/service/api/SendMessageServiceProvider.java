package com.carttocart.notification.service.api;

import com.carttocart.notification.model.dto.MessageDto;
import org.springframework.http.ResponseEntity;

public interface SendMessageServiceProvider {
    ResponseEntity<Object> callSmsProvider(MessageDto dto);
}
