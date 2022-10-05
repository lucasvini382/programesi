package com.programesi.api.repository;

import com.programesi.api.models.entity.Timework;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TimeworkRepository extends JpaRepository<Timework, Long> {
    Optional<Timework> findByUserIdAndInitials(Long userId, String initials);
}
