package org.example.eventify.controller.admin;

import lombok.RequiredArgsConstructor;
import org.example.eventify.model.dto.UserDTO;
import org.example.eventify.model.enums.Role;
import org.example.eventify.service.EventService;
import org.example.eventify.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;
    private final EventService eventService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/users/{id}/role")
    public ResponseEntity<UserDTO> changeUserRole(@PathVariable Integer id, @RequestParam String role) {

        UserDTO user = userService.getUserById(id);
        user.setRole(Enum.valueOf(Role.class, role));
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @DeleteMapping("/events/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Integer id) {
        eventService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
