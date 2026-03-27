package com.ambrogio.securityeventmonitor.dto;

import com.ambrogio.securityeventmonitor.entity.EventType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SecurityEventRequest {

    @NotNull(message = "Event type is required")
    private EventType eventType;

    private String username;

    @NotBlank(message = "IP address is required")
    private String ipAddress;

    private String userAgent;

    private String details;
}
