package com.OpenCrew.ERentCar.cars.domain.repository;

import java.util.List;
import java.util.Optional;

import com.OpenCrew.ERentCar.cars.domain.model.Favorite;

public interface FavoriteRepository {
    Optional<Favorite> findById(Long id);
    Favorite save(Favorite user);
    void deleteById(Long id);
    List<Favorite> findAllFavoritesByUserId(Long id);
}