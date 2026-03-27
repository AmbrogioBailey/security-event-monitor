package com.ambrogio.securityeventmonitor.repository;

import com.ambrogio.securityeventmonitor.entity.EventType;
import com.ambrogio.securityeventmonitor.entity.SecurityEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SecurityEventRepository extends JpaRepository<SecurityEvent, Long> {

    List<SecurityEvent> findByUsername(String username);

    List<SecurityEvent> findByEventType(EventType eventType);

    List<SecurityEvent> findByIpAddress(String ipAddress);

    List<SecurityEvent> findByTimestampBetween(LocalDateTime start, LocalDateTime end);
}
