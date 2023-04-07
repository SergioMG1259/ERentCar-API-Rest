package com.OpenCrew.ERentCar.cars.application.mapper;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.OpenCrew.ERentCar.cars.application.dto.CarDTO;
import com.OpenCrew.ERentCar.cars.application.dto.CarDetailsDTO;
import com.OpenCrew.ERentCar.cars.application.dto.CarDetailsRentDTO;
import com.OpenCrew.ERentCar.cars.application.dto.CarRegisterDTO;
import com.OpenCrew.ERentCar.cars.application.dto.CarShortDTO;
import com.OpenCrew.ERentCar.cars.application.dto.CarWithFavoriteDTO;
import com.OpenCrew.ERentCar.cars.domain.model.Car;
import com.OpenCrew.ERentCar.shared.mapping.EnhancedModelMapper;

public class CarMapper implements Serializable{
    @Autowired
    EnhancedModelMapper mapper;

    public CarDTO toDTO(Car model){
        return mapper.map(model, CarDTO.class);
    }
    public Car toModel(CarRegisterDTO carRegisterDTO){
        return mapper.map(carRegisterDTO, Car.class);
    }
    public CarDetailsRentDTO toCarDetailsRentDTO(Car model){return mapper.map(model, CarDetailsRentDTO.class);}
    public CarDetailsDTO toCarDetailsDTO(Car model){return mapper.map(model, CarDetailsDTO.class);}
    public List<CarDTO> modelListToListDTO(List<Car>modelList){
        return mapper.mapList(modelList, CarDTO.class);
    }
    public Page<CarDTO> modelListToPage(List<Car> modelList,Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,CarDTO.class),pageable,modelList.size());
    }
    public Page<CarWithFavoriteDTO> modelCarFavListToPage(List<CarWithFavoriteDTO> modelList,Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,CarWithFavoriteDTO.class),pageable,modelList.size());
    }
    public List<CarShortDTO> modelListToListShortDTO(List<Car>modelList){
        return mapper.mapList(modelList, CarShortDTO.class);
    }
    public Page<CarDTO> pageListToPage(Page<Car> pageList,Pageable pageable){
        return new PageImpl<>(mapper.mapList(pageList.getContent(),CarDTO.class),pageable,pageList.getTotalElements());
    }
}