package com.OpenCrew.ERentCar.cars.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OpenCrew.ERentCar.cars.application.dto.FavoriteDTO;
import com.OpenCrew.ERentCar.cars.application.mapper.FavoriteMapper;
import com.OpenCrew.ERentCar.cars.domain.service.FavoriteService;

@RestController
@RequestMapping("/api/v1/favorites")
public class FavoriteController {
    private FavoriteService favoriteService;
    private FavoriteMapper mapper;
    public FavoriteController(FavoriteService favoriteService, FavoriteMapper mapper) {
        this.favoriteService = favoriteService;
        this.mapper = mapper;
    }
    @PostMapping("register/car/{carId}/user/{userId}")
    public ResponseEntity<FavoriteDTO> registerFavorite(@PathVariable("carId")Long carId,
    @PathVariable("userId")Long userId){
        FavoriteDTO favoriteDTO= mapper.toDTO(this.favoriteService.registerFavorite(carId,userId));
        return ResponseEntity.ok(favoriteDTO);
    }
    
    @DeleteMapping("{favoriteId}")
    public ResponseEntity<?> deleteFavorite(@PathVariable Long favoriteId) {
        return this.favoriteService.deleteById(favoriteId);
    }
}
