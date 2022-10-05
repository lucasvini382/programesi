package com.programesi.api.services;

import com.programesi.api.models.dto.TimeworkDTO;
import com.programesi.api.models.dto.UserDTO;
import com.programesi.api.models.entity.Timework;
import com.programesi.api.models.entity.User;
import com.programesi.api.services.exceptions.UserAlreadyExistsException;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<User> findUsers();

    Optional<User> findUser(Long id);

    ResponseEntity<UserDTO> createUser(UserDTO model) throws UserAlreadyExistsException;

    ResponseEntity<TimeworkDTO> createTimeWork(TimeworkDTO model);

    List<Timework> findTimeworks();

    Optional<Timework> findTimework(Long id);
}
