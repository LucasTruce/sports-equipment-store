package com.store.model.user;

import java.util.List;
import java.util.stream.Collectors;

public class UserConverter {

    public UserDto entityToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setRoles(user.getRoles());
        userDto.setEnabled(user.isEnabled());
        return userDto;
    }

    public User dtoToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setRoles(userDto.getRoles());
        user.setEnabled(userDto.isEnabled());
        return user;
    }

    public List<UserDto> convertAllToDto(List<User> entityObjects){
        return entityObjects.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }
}
