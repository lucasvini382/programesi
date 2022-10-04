package com.programesi.api.repository;

import com.programesi.api.models.entity.Timework;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeworkRepository extends JpaRepository<Timework, Long> {
}
