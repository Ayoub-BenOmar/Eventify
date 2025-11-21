package org.example.eventify.model.mapper;

import org.example.eventify.model.dto.EventDTO;
import org.example.eventify.model.entity.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventMapper {

    @Mapping(source = "organizer.id", target = "organizerId")
    @Mapping(source = "organizer.name", target = "organizerName")
    EventDTO toDTO(Event event);

    @Mapping(source = "organizerId", target = "organizer.id")
    Event toEntity(EventDTO dto);
}

