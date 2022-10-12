package com.programesi.api.repository;

import com.programesi.api.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);

    Optional<User> findByLoginAndPassword(String login, String password);
}
