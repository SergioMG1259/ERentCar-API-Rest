package com.OpenCrew.ERentCar.cars.infraestructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OpenCrew.ERentCar.cars.domain.model.Favorite;
import com.OpenCrew.ERentCar.cars.domain.repository.FavoriteRepository;

@Repository
public interface FavoriteRepositoryImpl extends JpaRepository<Favorite,Long>, FavoriteRepository{
    
}
