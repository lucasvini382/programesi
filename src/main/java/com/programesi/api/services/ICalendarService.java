package com.programesi.api.services;

import com.programesi.api.models.dto.CalendarDTO;
import com.programesi.api.models.entity.Calendar;
import com.programesi.api.models.entity.Timework;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ICalendarService {

    ResponseEntity<CalendarDTO> createCalendar(CalendarDTO model);

    List<Calendar> findCalendars();

    Optional<Calendar> findCalendar(Long id);
}
