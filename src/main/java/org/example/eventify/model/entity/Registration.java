package org.example.eventify.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.eventify.model.enums.Statut;

import java.time.LocalDateTime;

@Entity
@Table(name = "registrations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    private Integer eventId;

    private LocalDateTime registeredAt;

    private Statut statut;
}
