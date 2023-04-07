package com.OpenCrew.ERentCar.cars.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarShortDTO {
    private Long id;

    private String brand;

    private String model;

    private int year;

    private Double pricePerDay;

    private String money;

    private String state;
}
