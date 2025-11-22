package org.example.eventify.controller;

import org.example.eventify.model.dto.EventDTO;
import org.example.eventify.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private EventService eventService;


    @PostMapping
    public ResponseEntity<EventDTO> createEvent(@RequestBody  EventDTO dto) {
        return ResponseEntity.ok(eventService.save(dto));
    }


    @GetMapping
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }


    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Integer id) {
        return ResponseEntity.ok(eventService.getById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> updateEvent(@PathVariable Integer id, @RequestBody EventDTO dto) {
        return ResponseEntity.ok(eventService.update(id, dto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Integer id) {
        eventService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
