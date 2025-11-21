package org.example.eventify.repository;

import org.example.eventify.model.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Integer, Event> {
}
