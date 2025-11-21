package org.example.eventify.model.mapper;

import org.example.eventify.model.dto.UserDTO;
import org.example.eventify.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User user);

    User toEntity(UserDTO userDTO);
}
