package com.carttocart.notification.service.impl;

import com.carttocart.notification.model.entity.ShortMessage;
import com.carttocart.notification.repository.ShortMessageRepository;
import com.carttocart.notification.service.api.SendMessageService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SendMessageServiceImpl implements SendMessageService {

    private final ShortMessageRepository shortMessageRepository;

    public SendMessageServiceImpl(ShortMessageRepository shortMessageRepository) {
        this.shortMessageRepository = shortMessageRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ShortMessage> messageDtoList(int page, int size) {
        return shortMessageRepository.shortMessageList(PageRequest.of(page, size));
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void updateShortMessage(ShortMessage shortMessage) {
        shortMessageRepository.save(shortMessage);
    }
}
