package com.OpenCrew.ERentCar.cars.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.OpenCrew.ERentCar.cars.domain.model.Car;

public interface CarRepository {
    Optional<Car> findById(Long id);
    List<Car> findAll();
    Car save(Car user);
    void deleteById(Long id);
    Page<Car> findAll(Pageable pageable);
    List<Car> findAllCarsByUserId(Long id);
}
