package com.carttocart.notification.service.impl;

import com.carttocart.notification.model.dto.MessageDto;
import com.carttocart.notification.service.api.SendMessageServiceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class SendMessageServiceProviderImpl implements SendMessageServiceProvider {

    private final RestTemplate restTemplate;

    @Value("${webservice.sms.provider.url}")
    private String provider2Url;

    public SendMessageServiceProviderImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<Object> callSmsProvider(MessageDto dto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<MessageDto> entity = new HttpEntity(dto, headers);
        return restTemplate.exchange(provider2Url, HttpMethod.POST, entity, Object.class);
    }
}
