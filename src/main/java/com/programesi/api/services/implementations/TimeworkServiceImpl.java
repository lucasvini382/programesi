package com.programesi.api.services.implementations;

import com.programesi.api.models.dto.TimeworkDTO;
import com.programesi.api.models.entity.Timework;
import com.programesi.api.models.entity.User;
import com.programesi.api.repository.TimeworkRepository;
import com.programesi.api.repository.UserRepository;
import com.programesi.api.services.ITimeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class TimeworkServiceImpl implements ITimeworkService {

    private final UserRepository userRepository;

    private final TimeworkRepository timeworkRepository;

    public TimeworkServiceImpl(@Autowired UserRepository userRepository, @Autowired TimeworkRepository timeworkRepository) {
        this.userRepository = userRepository;
        this.timeworkRepository = timeworkRepository;
    }

    @Override
    public ResponseEntity<TimeworkDTO> createTimeWork(TimeworkDTO model) {
        Optional<User> user = userRepository.findById(model.userId);
        Timework timework = new Timework();
        timework.setEntryHour(model.entryHour);
        timework.setExitHour(model.exitHour);
        timework.setDescription(model.description);
        timework.setInitials(model.initials);
        user.ifPresent(timework::setUser);
        timeworkRepository.save(timework);
        return ResponseEntity.created(URI.create("")).body(model);
    }

    @Override
    public List<Timework> findTimeworks() {
        return timeworkRepository.findAll();
    }

    @Override
    public Optional<Timework> findTimework(Long id) {
        return timeworkRepository.findById(id);
    }
}
