package com.OpenCrew.ERentCar.users.domain.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.OpenCrew.ERentCar.users.domain.model.User;

public interface UserService {
    User getById(Long id);
    /*User getByEmail(String email);*/
    List<User> getAll();
    User registerUser(User user);
    void deleteById(Long id);
    Page<User> getAll(Pageable pageable);
}
