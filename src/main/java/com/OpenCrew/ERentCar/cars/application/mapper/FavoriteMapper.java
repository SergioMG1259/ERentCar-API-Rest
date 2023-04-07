package com.OpenCrew.ERentCar.cars.application.mapper;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.OpenCrew.ERentCar.cars.application.dto.FavoriteDTO;
import com.OpenCrew.ERentCar.cars.domain.model.Favorite;
import com.OpenCrew.ERentCar.shared.mapping.EnhancedModelMapper;

public class FavoriteMapper implements Serializable{
    @Autowired
    EnhancedModelMapper mapper;
    public FavoriteDTO toDTO(Favorite model){
        return mapper.map(model, FavoriteDTO.class);
    }
}
