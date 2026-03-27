package com.ambrogio.securityeventmonitor.controller;

import com.ambrogio.securityeventmonitor.dto.SecurityEventRequest;
import com.ambrogio.securityeventmonitor.dto.SecurityEventResponse;
import com.ambrogio.securityeventmonitor.entity.EventType;
import com.ambrogio.securityeventmonitor.service.SecurityEventService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class SecurityEventController {

    private final SecurityEventService service;

    public SecurityEventController(SecurityEventService service) {
        this.service = service;
    }

    @PostMapping
    public SecurityEventResponse createEvent(@Valid @RequestBody SecurityEventRequest request) {
        return service.saveEvent(request);
    }

    @GetMapping
    public List<SecurityEventResponse> getAllEvents() {
        return service.getAllEvents();
    }

    @GetMapping("/{id}")
    public SecurityEventResponse getEventById(@PathVariable Long id) {
        return service.getEventById(id);
    }

    @GetMapping("/username/{username}")
    public List<SecurityEventResponse> getEventsByUsername(@PathVariable String username) {
        return service.getEventsByUsername(username);
    }

    @GetMapping("/type/{eventType}")
    public List<SecurityEventResponse> getEventsByEventType(@PathVariable EventType eventType) {
        return service.getEventsByEventType(eventType);
    }

    @GetMapping("/ip/{ipAddress}")
    public List<SecurityEventResponse> getEventsByIpAddress(@PathVariable String ipAddress) {
        return service.getEventsByIpAddress(ipAddress);
    }
}
