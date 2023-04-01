package com.OpenCrew.ERentCar.shared.util;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.stereotype.Component;

@Component
public class AuditListener {
    @PrePersist
    public void setCreatedAt(AuditableEntity entity) {
        entity.setCreatedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void setUpdatedAt(AuditableEntity entity) {
        entity.setCreatedAt(LocalDateTime.now());
    }
}
