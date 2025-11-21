package org.example.eventify.model.mapper;

import org.example.eventify.model.dto.RegistrationDTO;
import org.example.eventify.model.entity.Registration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RegistrationMapper {
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "event.id", target = "eventId")
    @Mapping(source = "statut", target = "statut")
    RegistrationDTO toDTO(Registration registration);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "eventId", target = "event.id")
    @Mapping(source = "statut", target = "statut")
    Registration toEntity(RegistrationDTO dto);
}
