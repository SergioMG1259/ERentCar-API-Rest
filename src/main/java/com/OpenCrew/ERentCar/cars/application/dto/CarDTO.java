package com.OpenCrew.ERentCar.cars.application.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDTO {
    private Long id;

    private String brand;

    private String model;

    private String type;

    private int seats;

    private int year;

    private String fuel;

    private String gearBox;

    private String plateNumber;

    private String description;

    private Double mileage;

    private Double pricePerDay;

    private String money;

    private Boolean addWheelChair;

    private Boolean addchildSeat;

    private Double score;

    private String state;

    private List<FeatureDTO> features;
}
