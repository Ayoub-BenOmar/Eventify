package org.example.eventify.repository;

import org.example.eventify.model.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Integer, Registration> {
}
