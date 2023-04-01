package com.OpenCrew.ERentCar.users.infraestructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OpenCrew.ERentCar.users.domain.model.User;
import com.OpenCrew.ERentCar.users.domain.repository.UserRepository;

@Repository
public interface UserRepositoryImpl extends JpaRepository<User,Long>,UserRepository{
    /*@Override
    Optional<User> findByEmail(String email);*/
}
