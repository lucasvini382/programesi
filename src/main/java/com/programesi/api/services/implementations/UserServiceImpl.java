package com.programesi.api.services.implementations;

import com.programesi.api.models.dto.UserDTO;
import com.programesi.api.models.entity.User;
import com.programesi.api.repository.UserRepository;
import com.programesi.api.services.IUserService;
import com.programesi.api.services.exceptions.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    public UserServiceImpl(@Autowired UserRepository repository) {
        this.userRepository = repository;
    }

    @Override
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public ResponseEntity<UserDTO> createUser(UserDTO model) throws UserAlreadyExistsException {
        if (!(userRepository.findByLogin(model.login) == null)) {
            throw new UserAlreadyExistsException();
        }
        User user = new User();
        user.setLogin(model.login);
        user.setPassword(model.password);
        user.setFirstName(model.firstName);
        user.setLastName(model.lastName);
        userRepository.save(user);
        return ResponseEntity.created(URI.create("")).body(model);
    }
}