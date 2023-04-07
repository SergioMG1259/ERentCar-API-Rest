package com.OpenCrew.ERentCar.cars.application.mapper;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.OpenCrew.ERentCar.cars.application.dto.LocationDTO;
import com.OpenCrew.ERentCar.cars.domain.model.Location;
import com.OpenCrew.ERentCar.shared.mapping.EnhancedModelMapper;

public class LocationMapper implements Serializable{
    @Autowired
    EnhancedModelMapper mapper;

    public LocationDTO toDTO(Location model){return mapper.map(model, LocationDTO.class);}
    public List<LocationDTO> modelListToListDTO(List<Location>modelList){
        return mapper.mapList(modelList, LocationDTO.class);
    }
    public List<Location> ListDTOListToModel(List<LocationDTO>ListDTO){
        return mapper.mapList(ListDTO, Location.class);
    }
}
