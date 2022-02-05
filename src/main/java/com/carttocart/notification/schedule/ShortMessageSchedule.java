package com.carttocart.notification.schedule;

import com.carttocart.notification.model.dto.MessageDto;
import com.carttocart.notification.model.entity.ShortMessage;
import com.carttocart.notification.service.api.SendMessageService;
import com.carttocart.notification.service.api.SendMessageServiceProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShortMessageSchedule {

    private final SendMessageService sendMessageService;
    private final SendMessageServiceProvider sendMessageServiceProvider;

    public ShortMessageSchedule(SendMessageService sendMessageService, SendMessageServiceProvider sendMessageServiceProvider) {
        this.sendMessageService = sendMessageService;
        this.sendMessageServiceProvider = sendMessageServiceProvider;
    }

    @Scheduled(fixedRate = 1000)
    public void sendMessages() {
        List<ShortMessage> messageList = sendMessageService.messageDtoList(0, 100);
        if (messageList != null && !messageList.isEmpty()) {
            messageList.stream().forEach(item -> {
                try {
                    ResponseEntity<Object> objectResponseEntity = sendMessageServiceProvider.callSmsProvider(MessageDto.map(item));
                    if (objectResponseEntity.getStatusCode().equals(HttpStatus.OK)) {
                        item.setCounter(item.getCounter() + 1);
                        item.setSendingFlag(true);
                        sendMessageService.updateShortMessage(item);
                    } else {
                        item.setCounter(item.getCounter() + 1);
                        sendMessageService.updateShortMessage(item);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    item.setCounter(item.getCounter() + 1);
                    sendMessageService.updateShortMessage(item);
                }
            });
        }
    }
}
