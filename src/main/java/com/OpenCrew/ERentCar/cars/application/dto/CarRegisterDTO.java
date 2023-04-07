package com.OpenCrew.ERentCar.cars.application.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarRegisterDTO {
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

    private List<FeatureDTO> features;

    private List<LocationDTO> locations;
}
