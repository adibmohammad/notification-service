package com.carttocart.notification.model.entity;


import com.carttocart.notification.model.common.AuditModel;

import javax.persistence.*;

@Entity
@Table(name = "sms")
public class ShortMessage extends AuditModel<Long> {

    private String text;
    private Integer counter;
    private Boolean sendingFlag;
    private String mobileNumber;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return super.getId();
    }

    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column(name = "counter")
    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    @Column(name = "send_flag")
    public Boolean getSendingFlag() {
        return sendingFlag;
    }

    public void setSendingFlag(Boolean sendingFlag) {
        this.sendingFlag = sendingFlag;
    }

    @Column(name = "mobile_number")
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
