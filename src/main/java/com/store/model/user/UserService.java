package com.store.model.user;

import java.util.List;

public interface UserService {
    UserDto saveUser(UserDto userDto);
    List<UserDto> getUsers();
}
