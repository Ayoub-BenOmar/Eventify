package org.example.eventify.service;

import lombok.*;
import org.example.eventify.model.dto.RegistrationDTO;
import org.example.eventify.model.entity.Event;
import org.example.eventify.model.entity.Registration;
import org.example.eventify.model.entity.User;
import org.example.eventify.model.enums.Statut;
import org.example.eventify.model.mapper.RegistrationMapper;
import org.example.eventify.repository.EventRepository;
import org.example.eventify.repository.RegistrationRepository;
import org.example.eventify.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final RegistrationMapper registrationMapper;

    public RegistrationDTO save(RegistrationDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id " + dto.getUserId()));

        Event event = eventRepository.findById(dto.getEventId())
                .orElseThrow(() -> new RuntimeException("Event not found with id " + dto.getEventId()));

        Registration registration = Registration.builder()
                .user(user)
                .event(event)
                .registeredAt(LocalDateTime.now())
                .statut(dto.getStatut() != null ?
                        Statut.valueOf(dto.getStatut()) :
                        Statut.PENDING)
                .build();
        return registrationMapper.toDTO(registrationRepository.save(registration));
    }

    public List<RegistrationDTO> getAll() {
        return registrationRepository.findAll().stream()
                .map(registrationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RegistrationDTO getRegistrationById(Integer id) {
        Registration registration = registrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registration not found with id " + id));
        return registrationMapper.toDTO(registration);
    }

    public RegistrationDTO update(Integer id, RegistrationDTO dto) {
        Registration registration = registrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registration not found with id " + id));

        if (dto.getStatut() != null) {
            registration.setStatut(Statut.valueOf(dto.getStatut()));

        }
        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found with id " + dto.getUserId()));
            registration.setUser(user);
        }

        if (dto.getEventId() != null) {
            Event event = eventRepository.findById(dto.getEventId())
                    .orElseThrow(() -> new RuntimeException("Event not found with id " + dto.getEventId()));
            registration.setEvent(event);
        }

        return registrationMapper.toDTO(registrationRepository.save(registration));
    }

    public void delete(Integer id) {
        Registration registration = registrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registration not found with id " + id));
        registrationRepository.delete(registration);
    }

    public RegistrationDTO registerLoggedUserToEvent(Integer eventId) {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Événement introuvable"));

        Registration registration = Registration.builder()
                .user(user)
                .event(event)
                .registeredAt(LocalDateTime.now())
                .statut(Statut.PENDING)
                .build();

        return registrationMapper.toDTO(registrationRepository.save(registration));
    }

    public List<RegistrationDTO> getRegistrationsForCurrentUser() {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        return registrationRepository.findByUserId(user.getId())
                .stream()
                .map(registrationMapper::toDTO)
                .collect(Collectors.toList());
    }
}
