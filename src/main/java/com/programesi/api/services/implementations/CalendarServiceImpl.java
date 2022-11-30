package com.programesi.api.services.implementations;

import com.programesi.api.models.dto.CalendarDTO;
import com.programesi.api.models.entity.Calendar;
import com.programesi.api.models.entity.Timework;
import com.programesi.api.repository.CalendarRepository;
import com.programesi.api.repository.TimeworkRepository;
import com.programesi.api.repository.UserRepository;
import com.programesi.api.services.ICalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CalendarServiceImpl implements ICalendarService {

    private final CalendarRepository calendarRepository;
    private final TimeworkRepository timeworkRepository;
    private final UserRepository userRepository;

    public CalendarServiceImpl(
            @Autowired CalendarRepository calendarRepository,
            @Autowired TimeworkRepository timeworkRepository,
            @Autowired UserRepository userRepository) {
        this.calendarRepository = calendarRepository;
        this.timeworkRepository = timeworkRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<CalendarDTO> createCalendar(CalendarDTO model) {
        Optional <Timework> timework = timeworkRepository.findByUserIdAndInitials(model.userId, model.initials);
        Calendar calendar = new Calendar();
        calendar.setDate(LocalDate.parse(model.date));
        timework.ifPresent(calendar::setTimework);
        calendarRepository.save(calendar);
        return ResponseEntity.created(URI.create("")).body(model);
    }

    @Override
    public List<Calendar> findCalendars() {
        return calendarRepository.findAll();
    }

    @Override
    public Optional<Calendar> findCalendar(Long id) {
        return calendarRepository.findById(id);
    }
}
