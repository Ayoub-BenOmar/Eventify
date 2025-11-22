package org.example.eventify.repository;

import org.example.eventify.model.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Integer> {
    List<Registration> findByUserId(Integer userId);
}
