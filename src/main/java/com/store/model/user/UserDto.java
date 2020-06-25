package com.store.model.user;

import com.store.model.role.Role;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private String email;
    private boolean enabled;
    private List<Role> roles;
}
