package com.OpenCrew.ERentCar.users.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.OpenCrew.ERentCar.users.domain.model.User;

public interface UserRepository {
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    List<User> findAll();
    User save(User user);
    void deleteById(Long id);
    Page<User> findAll(Pageable pageable);
}
