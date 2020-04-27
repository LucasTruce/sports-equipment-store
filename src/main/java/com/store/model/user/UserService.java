package com.store.model.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userConverter = new UserConverter();
    }

    public UserDto saveUser(UserDto userDto) {
        User user = userConverter.dtoToEntity(userDto);
        return userConverter.entityToDto(userRepository.save(user));
    }

    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        return userConverter.convertAllToDto(users);
    }

}
