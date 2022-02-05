package com.carttocart.notification.model.common;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.io.Serializable;

@MappedSuperclass
public class BaseModel <T extends Number> implements Serializable {

    private T id;

    @Transient
    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
