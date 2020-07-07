package com.store.model.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserLoginDto {

    private final String username;
    private final String password;
    private final String email;

}
