package com.OpenCrew.ERentCar.cars.application.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OpenCrew.ERentCar.cars.application.dto.CarDTO;
import com.OpenCrew.ERentCar.cars.application.dto.CarDetailsDTO;
import com.OpenCrew.ERentCar.cars.application.dto.CarDetailsRentDTO;
import com.OpenCrew.ERentCar.cars.application.dto.CarRegisterDTO;
import com.OpenCrew.ERentCar.cars.application.dto.CarShortDTO;
import com.OpenCrew.ERentCar.cars.application.dto.CarWithFavoriteDTO;
import com.OpenCrew.ERentCar.cars.application.mapper.CarMapper;
import com.OpenCrew.ERentCar.cars.domain.service.CarService;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {
    private CarService carService;
    private CarMapper carMapper;
    public CarController(CarService carService, CarMapper carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }
    @GetMapping
    public List<CarDTO>getAllCars(){
        return carMapper.modelListToListDTO(this.carService.getAll());
    }
    @GetMapping("/my-cars/owner/{ownerId}")
    public List<CarShortDTO>getAllCarsByUser(@PathVariable("ownerId")Long ownerId){
        return carMapper.modelListToListShortDTO(this.carService.getByUserId(ownerId));
    }
    @GetMapping("/my-cars/{carId}")
    public ResponseEntity<CarDetailsDTO> getCarDetailsById(@PathVariable Long carId){
        CarDetailsDTO carDetailsDTO=carMapper.toCarDetailsDTO(this.carService.getById(carId));
        return ResponseEntity.ok(carDetailsDTO);
    }
    /*@GetMapping("/paged")
    public Page<CarDTO>getAllCarsPaged(Pageable pageable){
        return carMapper.modelListToPage(this.carService.getAll(), pageable);
    }*/
    /*@GetMapping("/page/{numberPage}")
    public Page<CarDTO>getAllCarsPaged(@PathVariable int numberPage){
        Pageable pageable=PageRequest.of(numberPage, 10);
        return carMapper.pageListToPage(this.carService.getAll(pageable), pageable);
    }*/
    @GetMapping("/user/{userId}/page/{numberPage}")
    public Page<CarWithFavoriteDTO>getAllCarsPaged(@PathVariable("userId")Long userId,@PathVariable int numberPage){
        Pageable pageable=PageRequest.of(numberPage, 10);
        return carMapper.modelCarFavListToPage(this.carService.getAll(pageable,userId), pageable);
    }
    @GetMapping("{carId}")
    public ResponseEntity<CarDTO> getById(@PathVariable Long carId){
        CarDTO carDTO=carMapper.toDTO(this.carService.getById(carId));
        return ResponseEntity.ok(carDTO);
    }
    @GetMapping("/details/{carId}")
    public ResponseEntity<CarDetailsRentDTO> getCarDetailsRentById(@PathVariable Long carId){
        CarDetailsRentDTO carDetailsRentDTO=carMapper.toCarDetailsRentDTO(this.carService.getById(carId));
        return ResponseEntity.ok(carDetailsRentDTO);
    }
    @PostMapping("register/owner/{ownerId}")
    public ResponseEntity<CarDTO> registerCar(@PathVariable("ownerId")Long ownerId,@Valid @RequestBody CarRegisterDTO request){
        CarDTO carDTO= carMapper.toDTO(this.carService.registerCar(carMapper.toModel(request),ownerId));
        return ResponseEntity.ok(carDTO);
    }   
}