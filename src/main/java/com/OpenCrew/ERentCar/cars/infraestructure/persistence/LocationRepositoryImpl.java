package com.OpenCrew.ERentCar.cars.infraestructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OpenCrew.ERentCar.cars.domain.model.Location;
import com.OpenCrew.ERentCar.cars.domain.repository.LocationRepository;

@Repository
public interface LocationRepositoryImpl extends JpaRepository<Location,Long>, LocationRepository{
    
}
