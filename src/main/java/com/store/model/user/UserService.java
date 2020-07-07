package com.store.model.user;


import com.store.model.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserConverter userConverter;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder pass, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userConverter = new UserConverter();
        this.passwordEncoder = pass;
        this.roleRepository = roleRepository;
    }

    public UserIdentificationDto saveUser(UserLoginDto userLoginDto) {
        User user = userConverter.map(userLoginDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setRoles(Collections.singletonList(roleRepository.getOne(2L)));
        user.setEnabled(true);

        return userConverter.map(userRepository.save(user));
    }

    public List<UserIdentificationDto> getUsers() {
        return userConverter.map(userRepository.findAll());
    }


}
