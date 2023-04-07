package com.OpenCrew.ERentCar.cars.domain.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.OpenCrew.ERentCar.cars.application.dto.CarWithFavoriteDTO;
import com.OpenCrew.ERentCar.cars.domain.model.Car;

public interface CarService {
    Car getById(Long id);
    List<Car> getAll();
    Car registerCar(Car car,Long ownerId);
    void deleteById(Long id);
    List<CarWithFavoriteDTO> getAll(Pageable pageable,Long userId);
    List<Car> getByUserId(Long ownerId);
}
