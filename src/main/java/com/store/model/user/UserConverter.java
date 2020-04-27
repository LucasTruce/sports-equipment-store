package com.store.model.user;

import java.util.List;
import java.util.stream.Collectors;

public class UserConverter {

    public UserDto entityToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    public User dtoToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public List<UserDto> convertAllToDto(List<User> entityObjects){
        return entityObjects.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }
}
