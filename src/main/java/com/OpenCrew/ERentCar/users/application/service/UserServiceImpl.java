package com.OpenCrew.ERentCar.users.application.service;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.OpenCrew.ERentCar.shared.exception.ResourceNotFoundException;
import com.OpenCrew.ERentCar.shared.exception.ResourceValidationException;
import com.OpenCrew.ERentCar.users.domain.model.User;
import com.OpenCrew.ERentCar.users.domain.repository.UserRepository;
import com.OpenCrew.ERentCar.users.domain.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final Validator validator;

    public UserServiceImpl(UserRepository userRepository,Validator validator) {
        this.userRepository = userRepository;
        this.validator=validator;
    }

    @Override
    public User getById(Long id) {
        return this.userRepository.findById(id)
        .orElseThrow(()->new ResourceNotFoundException("USER",id));
    }

    /*@Override
    public User getByEmail(String email) {
       
        throw new UnsupportedOperationException("Unimplemented method 'getByEmail'");
    }*/

    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User registerUser(User user) {
        Set<ConstraintViolation<User>>violations=validator.validate(user);
        if(!violations.isEmpty()){
            throw new ResourceValidationException("USER",violations);
        }
        if(this.userRepository.findByEmail(user.getEmail()).isPresent()){
            /*throw new BadRequestException("Email already in use");*/
        }
        
        return this.userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }
    
}
