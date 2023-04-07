package com.OpenCrew.ERentCar.cars.application.dto;

import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Setter
@AllArgsConstructor
public class CarWithFavoriteDTO {
    private CarDTO carDTO;
    private boolean favorite;
    private Long favoriteId;
}
