package com.store.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.saveUser(userDto), HttpStatus.OK);
    }
}
