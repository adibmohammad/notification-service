package com.carttocart.notification.model.common;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class AuditModel<T extends Number> extends BaseModel<Long> {

    private Date creationDate;
    private Date lastUpdate;

    @Column(name = "creation_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Column(name = "last_update")
    @Temporal(value = TemporalType.TIMESTAMP)
    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @PrePersist
    void createdAt() {
        this.creationDate = this.lastUpdate = new Date();
    }

    @PreUpdate
    void updatedAt() {
        this.lastUpdate = new Date();
    }
}
