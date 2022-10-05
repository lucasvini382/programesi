package com.programesi.api.services;

import com.programesi.api.models.dto.CalendarDTO;
import com.programesi.api.models.entity.Timework;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ICalendarService {

    ResponseEntity<CalendarDTO> createCalendar(CalendarDTO model);

    List<Timework> findTimeworks();

    Optional<Timework> findTimework(Long id);
}
