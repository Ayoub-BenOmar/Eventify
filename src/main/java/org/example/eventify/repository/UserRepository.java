package org.example.eventify.repository;

import org.example.eventify.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Integer, User> {
}
