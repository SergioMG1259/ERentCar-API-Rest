package com.OpenCrew.ERentCar.cars.domain.repository;

import com.OpenCrew.ERentCar.cars.domain.model.Feature;

public interface FeatureRepository {
    Feature save(Feature feature);
    void deleteById(Long id);
}
