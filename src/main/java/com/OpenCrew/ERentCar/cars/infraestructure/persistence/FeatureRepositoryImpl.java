package com.OpenCrew.ERentCar.cars.infraestructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OpenCrew.ERentCar.cars.domain.model.Feature;
import com.OpenCrew.ERentCar.cars.domain.repository.FeatureRepository;

@Repository
public interface FeatureRepositoryImpl extends JpaRepository<Feature,Long>,FeatureRepository{
    
}
