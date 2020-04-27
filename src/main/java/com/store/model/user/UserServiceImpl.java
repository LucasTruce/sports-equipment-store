package com.store.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        userConverter = new UserConverter();
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = userConverter.dtoToEntity(userDto);
        return userConverter.entityToDto(userRepository.save(user));
    }

    @Override
    public List<UserDto> getUsers() {
       List<User> users = userRepository.findAll();
        return userConverter.convertAllToDto(users);
    }

}
