package com.ambrogio.securityeventmonitor.service;

import com.ambrogio.securityeventmonitor.dto.SecurityEventRequest;
import com.ambrogio.securityeventmonitor.dto.SecurityEventResponse;
import com.ambrogio.securityeventmonitor.entity.EventType;
import com.ambrogio.securityeventmonitor.entity.SecurityEvent;
import com.ambrogio.securityeventmonitor.exception.ResourceNotFoundException;
import com.ambrogio.securityeventmonitor.repository.SecurityEventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SecurityEventService {

    private final SecurityEventRepository repository;

    public SecurityEventService(SecurityEventRepository repository) {
        this.repository = repository;
    }

    public SecurityEventResponse saveEvent(SecurityEventRequest request) {
        SecurityEvent event = SecurityEvent.builder()
                .eventType(request.getEventType())
                .username(request.getUsername())
                .ipAddress(request.getIpAddress())
                .userAgent(request.getUserAgent())
                .timestamp(LocalDateTime.now())
                .details(request.getDetails())
                .build();

        SecurityEvent savedEvent = repository.save(event);
        return mapToResponse(savedEvent);
    }

    public List<SecurityEventResponse> getAllEvents() {
        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public SecurityEventResponse getEventById(Long id) {
        SecurityEvent event = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + id));
        return mapToResponse(event);
    }

    public List<SecurityEventResponse> getEventsByUsername(String username) {
        return repository.findByUsername(username)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public List<SecurityEventResponse> getEventsByEventType(EventType eventType) {
        return repository.findByEventType(eventType)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public List<SecurityEventResponse> getEventsByIpAddress(String ipAddress) {
        return repository.findByIpAddress(ipAddress)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private SecurityEventResponse mapToResponse(SecurityEvent event) {
        return SecurityEventResponse.builder()
                .id(event.getId())
                .eventType(event.getEventType())
                .username(event.getUsername())
                .ipAddress(event.getIpAddress())
                .userAgent(event.getUserAgent())
                .timestamp(event.getTimestamp())
                .details(event.getDetails())
                .build();
    }
}
