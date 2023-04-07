package com.OpenCrew.ERentCar.cars.application.mapper;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.OpenCrew.ERentCar.cars.application.dto.FeatureDTO;
import com.OpenCrew.ERentCar.cars.domain.model.Feature;
import com.OpenCrew.ERentCar.shared.mapping.EnhancedModelMapper;

public class FeatureMapper implements Serializable{
    @Autowired
    EnhancedModelMapper mapper;

    public FeatureDTO toDTO(Feature model){return mapper.map(model, FeatureDTO.class);}
    public List<FeatureDTO> modelListToListDTO(List<Feature>modelList){
        return mapper.mapList(modelList, FeatureDTO.class);
    }
    public List<Feature> ListDTOListToModel(List<FeatureDTO>ListDTO){
        return mapper.mapList(ListDTO, Feature.class);
    }
}
