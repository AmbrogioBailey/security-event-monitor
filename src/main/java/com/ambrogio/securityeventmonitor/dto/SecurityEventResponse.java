package com.ambrogio.securityeventmonitor.dto;

import com.ambrogio.securityeventmonitor.entity.EventType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class SecurityEventResponse {

    private Long id;
    private EventType eventType;
    private String username;
    private String ipAddress;
    private String userAgent;
    private LocalDateTime timestamp;
    private String details;
}
