package com.store.model.user;

import java.util.List;
import java.util.stream.Collectors;

public class UserConverter {

    public UserIdentificationDto map(User user) {
        return new UserIdentificationDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.isEnabled()
        );
    }

    public User map(UserIdentificationDto userIdentificationDto) {
        User user = new User();
        user.setId(userIdentificationDto.getId());
        user.setUsername(userIdentificationDto.getUsername());
        user.setEmail(userIdentificationDto.getEmail());
        user.setEnabled(userIdentificationDto.isEnabled());
        return user;
    }

    public User map(UserLoginDto userLoginDto) {
        User user = new User();
        user.setUsername(userLoginDto.getUsername());
        user.setPassword(userLoginDto.getPassword());
        user.setEmail(userLoginDto.getEmail());

        return user;
    }

    public List<UserIdentificationDto> map(List<User> entityObjects){
        return entityObjects.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
