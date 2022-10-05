package com.programesi.api.services;

import com.programesi.api.models.dto.TimeworkDTO;
import com.programesi.api.models.entity.Timework;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ITimeworkService {

    ResponseEntity<TimeworkDTO> createTimeWork(TimeworkDTO model);

    List<Timework> findTimeworks();

    Optional<Timework> findTimework(Long id);
}
