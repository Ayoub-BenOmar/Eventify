package org.example.eventify.controller.guest;

import lombok.RequiredArgsConstructor;
import org.example.eventify.model.dto.EventDTO;
import org.example.eventify.model.dto.UserDTO;
import org.example.eventify.service.EventService;
import org.example.eventify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public")
@RequiredArgsConstructor
public class PublicController {

    private final UserService userService;
    private final EventService eventService;

    @PostMapping("/users")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.save(userDTO));
    }

    @GetMapping("/events")
    public ResponseEntity<List<EventDTO>> getPublicEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }
}
