package org.example.eventify.model.dto;

import lombok.*;
import org.example.eventify.model.enums.Statut;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationDTO {
    private Integer id;
    private Integer userId;
    private Integer eventId;
    private LocalDateTime registeredAt;
    private String statut;
}
