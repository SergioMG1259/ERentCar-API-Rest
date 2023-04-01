package com.OpenCrew.ERentCar.users.application.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OpenCrew.ERentCar.users.application.dto.UserDTO;
import com.OpenCrew.ERentCar.users.application.dto.UserRegisterDTO;
import com.OpenCrew.ERentCar.users.application.mapper.UserMapper;
import com.OpenCrew.ERentCar.users.domain.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    private final UserMapper mapper;

    public UserController(UserService userService, UserMapper mapper){
        this.userService=userService;
        this.mapper=mapper;
    }
    @GetMapping
    public List<UserDTO>getAllUsers(){
        return mapper.modelListToListDTO(this.userService.getAll());
    }
    @GetMapping("/paged")
    public Page<UserDTO>getAllUsersPaged(Pageable pageable){
        return mapper.modelListToPage(this.userService.getAll(), pageable);
    }
    @GetMapping("{userId}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long userId){
        UserDTO userDTO=mapper.toDTO(this.userService.getById(userId));
        return ResponseEntity.ok(userDTO);
    }
    @PostMapping("register")
    public ResponseEntity<UserDTO> registerUser(@Valid @RequestBody UserRegisterDTO request){
        UserDTO userDTO= mapper.toDTO(this.userService.registerUser(mapper.toModel(request)));
        return ResponseEntity.ok(userDTO);
    }
}
