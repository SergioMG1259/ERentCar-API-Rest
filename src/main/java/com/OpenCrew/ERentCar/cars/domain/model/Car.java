package com.OpenCrew.ERentCar.cars.domain.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.OpenCrew.ERentCar.shared.util.AuditableEntity;
import com.OpenCrew.ERentCar.users.domain.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cars")
public class Car extends AuditableEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String brand;

    @NotNull
    @NotBlank
    private String model;

    @NotNull
    @NotBlank
    private String type;

    @NotNull
    private int seats;

    @NotNull
    private int year;

    @NotNull
    @NotBlank
    private String fuel;

    @NotNull
    @NotBlank
    private String gearBox;

    @NotNull
    @NotBlank
    private String plateNumber;

    @NotNull
    @NotBlank
    @Size(max = 200)
    private String description;

    @NotNull
    private Double mileage;

    @NotNull
    private Double pricePerDay;

    @NotNull
    @NotBlank
    private String money;

    @NotNull
    private Boolean addWheelChair;

    @NotNull
    private Boolean addchildSeat;

    private Double score=0.0;

    @NotNull
    @NotBlank
    private String state="FREE";

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Feature> features;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Location> locations;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Favorite> favorites;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
