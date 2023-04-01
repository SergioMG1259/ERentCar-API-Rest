package com.OpenCrew.ERentCar.users.application.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterDTO {
    @NotNull
    @NotBlank
    @Size(max = 20)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 20)
    private String lastName;

    @NotNull
    @NotBlank
    @Size(max = 200)
    private String description;

    @NotNull
    @NotBlank
    @Size(max = 30)
    private String email;

    @NotBlank(message = "Invalid password: Empty number")
    @NotNull(message = "Invalid password: Is NULL")
    @Size(max = 30)
    private String password;

    @NotNull
    private String photo;

    @NotNull
    private int spanishLevel;

    @NotNull
    private int englishLevel;

    @NotNull
    private String role;
}
