package org.example.eventify.model.dto;

import lombok.*;
import org.example.eventify.model.enums.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private Role role;
}
