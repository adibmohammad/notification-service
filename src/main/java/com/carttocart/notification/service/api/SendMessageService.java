package com.carttocart.notification.service.api;

import com.carttocart.notification.model.dto.MessageDto;
import com.carttocart.notification.model.entity.ShortMessage;

import java.util.List;

public interface SendMessageService {

    List<ShortMessage> messageDtoList(int page, int size);
    void updateShortMessage(ShortMessage shortMessage);
}
