package org.example.eventify.controller.user;

import lombok.RequiredArgsConstructor;
import org.example.eventify.model.dto.RegistrationDTO;
import org.example.eventify.model.dto.UserDTO;
import org.example.eventify.service.RegistrationService;
import org.example.eventify.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private UserService userService;
    private RegistrationService registrationService;

    @GetMapping("/profile")
    public ResponseEntity<UserDTO> getProfile() {
        return ResponseEntity.ok(userService.getCurrentUserProfile());
    }

    @PostMapping("/events/{eventId}/register")
    public ResponseEntity<RegistrationDTO> registerToEvent(@PathVariable Integer eventId) {
        return ResponseEntity.ok(registrationService.registerLoggedUserToEvent(eventId));
    }

    @GetMapping("/registrations")
    public ResponseEntity<List<RegistrationDTO>> getUserRegistrations() {
        return ResponseEntity.ok(registrationService.getRegistrationsForCurrentUser());
    }
}
