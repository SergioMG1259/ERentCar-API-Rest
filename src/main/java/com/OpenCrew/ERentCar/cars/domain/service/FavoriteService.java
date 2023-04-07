package com.OpenCrew.ERentCar.cars.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.OpenCrew.ERentCar.cars.domain.model.Favorite;

public interface FavoriteService {
    Favorite registerFavorite(Long carId,Long userId);
    ResponseEntity<?> deleteById(Long id);
    Page<Favorite> getByUserId(Pageable pageable);
}