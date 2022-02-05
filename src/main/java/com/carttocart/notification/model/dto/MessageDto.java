package com.carttocart.notification.model.dto;

import com.carttocart.notification.model.entity.ShortMessage;

public class MessageDto {

    private String message;
    private String mobileNumber;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public static MessageDto map(ShortMessage request){
        MessageDto dto = new MessageDto();
        dto.setMessage(request.getText());
        dto.setMobileNumber(request.getMobileNumber());
        return dto;
    }
}
