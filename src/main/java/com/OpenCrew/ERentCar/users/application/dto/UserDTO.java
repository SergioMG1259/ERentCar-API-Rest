package com.OpenCrew.ERentCar.users.application.dto;

import com.OpenCrew.ERentCar.users.domain.model.UserRole;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long id;

    private String name;

    private String lastName;

    private String description;

    private String email;

    private String photo;

    private int spanishLevel;

    private int englishLevel;

    private Double score;

    private UserRole role;
}
