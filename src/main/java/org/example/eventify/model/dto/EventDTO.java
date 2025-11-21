package org.example.eventify.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDTO {
    private Integer id;
    private String title;
    private String description;
    private String location;
    private LocalDateTime dateTime;
    private Integer capacity;
    private Integer organizerId;
}
