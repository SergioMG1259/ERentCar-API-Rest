package com.OpenCrew.ERentCar.users.application.mapper;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.OpenCrew.ERentCar.shared.exception.ResourceValidationException;
import com.OpenCrew.ERentCar.shared.mapping.EnhancedModelMapper;
import com.OpenCrew.ERentCar.users.application.dto.UserDTO;
import com.OpenCrew.ERentCar.users.application.dto.UserRegisterDTO;
import com.OpenCrew.ERentCar.users.domain.model.User;
import com.OpenCrew.ERentCar.users.domain.model.UserRole;

public class UserMapper implements Serializable{
    @Autowired
    EnhancedModelMapper mapper;

    public UserDTO toDTO(User model){return mapper.map(model, UserDTO.class);}
    public User toModel(UserRegisterDTO userRegisterDTO){
        UserRole userRole=UserRole.valueOf(userRegisterDTO.getRole().toUpperCase());
        if(userRole==null){
            throw new ResourceValidationException("Invalid role value");
        }
        User user=mapper.map(userRegisterDTO, User.class);
        user.setRole(userRole);
        return user;
    }
    public List<UserDTO> modelListToListDTO(List<User>modelList){
        return mapper.mapList(modelList, UserDTO.class);
    }
    public Page<UserDTO> modelListToPage(List<User> modelList,Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,UserDTO.class),pageable,modelList.size());
    }
}