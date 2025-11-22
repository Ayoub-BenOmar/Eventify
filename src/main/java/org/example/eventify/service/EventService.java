package org.example.eventify.service;

import lombok.*;
import org.example.eventify.exception.EventNotFoundException;
import org.example.eventify.model.dto.EventDTO;
import org.example.eventify.model.entity.Event;
import org.example.eventify.model.entity.User;
import org.example.eventify.model.mapper.EventMapper;
import org.example.eventify.repository.EventRepository;
import org.example.eventify.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private  final  UserService userService;
    private EventMapper eventMapper;

    public EventDTO save(EventDTO dto) {
        User organizer = userService.getCurrentUserEntity();

        Event event = eventMapper.toEntity(dto);
        event.setOrganizer(organizer);

        event = eventRepository.save(event);
        return eventMapper.toDTO(event);
    }

    public List<EventDTO> getAllEvents() {
        return eventRepository.findAll()
                .stream()
                .map(eventMapper::toDTO)
                .collect(Collectors.toList());
    }

    public EventDTO getById(Integer id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() ->  new EventNotFoundException("Event not found with id: " + id));
        return eventMapper.toDTO(event);
    }

    public EventDTO update(Integer id, EventDTO dto) {
        Event existing = eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException("Event not found with id: " + id));

        existing.setTitle(dto.getTitle());
        existing.setDescription(dto.getDescription());
        existing.setLocation(dto.getLocation());
        existing.setDateTime(dto.getDateTime());
        existing.setCapacity(dto.getCapacity());


        if (dto.getOrganizerId() != null) {
            User organizer = userRepository.findById(dto.getOrganizerId())
                    .orElseThrow(() -> new RuntimeException("Organizer not found"));
            existing.setOrganizer(organizer);
        }

        existing = eventRepository.save(existing);
        return eventMapper.toDTO(existing);
    }

    public void delete(Integer id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() ->  new EventNotFoundException("Event not found with id: " + id));
        eventRepository.delete(event);
    }
}
