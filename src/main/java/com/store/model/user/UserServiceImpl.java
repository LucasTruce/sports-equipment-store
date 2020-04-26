package com.store.model.user;

import com.store.model.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, Converter<User, UserDto> {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = dtoToEntity(userDto, User.class);
        return entityToDto(userRepository.save(user), UserDto.class);
    }

    @Override
    public List<UserDto> getUsers() {
       List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> entityToDto(user, UserDto.class))
                .collect(Collectors.toList());
    }

}
