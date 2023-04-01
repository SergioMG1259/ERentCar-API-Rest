package com.OpenCrew.ERentCar.users.domain.model;

import java.io.Serializable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.OpenCrew.ERentCar.shared.util.AuditableEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")

public class User extends AuditableEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @NotNull
    @NotBlank
    @Size(max = 30)
    private String password;

    @NotNull
    private String photo;

    @NotNull
    private int spanishLevel;

    @NotNull
    private int englishLevel;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
