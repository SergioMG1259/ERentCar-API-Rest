package com.OpenCrew.ERentCar.cars.domain.repository;

import com.OpenCrew.ERentCar.cars.domain.model.Location;

public interface LocationRepository {
    Location save(Location location);
    void deleteById(Long id);
}
