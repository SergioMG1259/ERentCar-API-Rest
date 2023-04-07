package com.OpenCrew.ERentCar.cars.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.OpenCrew.ERentCar.cars.application.dto.CarDTO;
import com.OpenCrew.ERentCar.cars.application.dto.CarWithFavoriteDTO;
import com.OpenCrew.ERentCar.cars.application.mapper.CarMapper;
import com.OpenCrew.ERentCar.cars.domain.model.Car;
import com.OpenCrew.ERentCar.cars.domain.model.Favorite;
import com.OpenCrew.ERentCar.cars.domain.model.Feature;
import com.OpenCrew.ERentCar.cars.domain.model.Location;
import com.OpenCrew.ERentCar.cars.domain.repository.CarRepository;
import com.OpenCrew.ERentCar.cars.domain.repository.FavoriteRepository;
import com.OpenCrew.ERentCar.cars.domain.service.CarService;
import com.OpenCrew.ERentCar.shared.exception.aber.BadRequestException;
import com.OpenCrew.ERentCar.shared.exception.aber.ResourceNotFound;
import com.OpenCrew.ERentCar.users.domain.model.User;
import com.OpenCrew.ERentCar.users.domain.repository.UserRepository;

@Service
public class CarServiceImpl implements CarService{
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final FavoriteRepository favoriteRepository;
    private final CarMapper carMapper;
    private final Validator validator;

    public CarServiceImpl(CarRepository carRepository,UserRepository userRepository,
    FavoriteRepository favoriteRepository,CarMapper carMapper,Validator validator) {
        this.carRepository = carRepository;
        this.userRepository=userRepository;
        this.favoriteRepository=favoriteRepository;
        this.carMapper=carMapper;
        this.validator = validator;
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Car> getAll() {
        return this.carRepository.findAll();
    }

    @Override
    public List<CarWithFavoriteDTO> getAll(Pageable pageable,Long userId) {
        Page<Car> cars=this.carRepository.findAll(pageable);
        Page<CarDTO> carsDTO=this.carMapper.pageListToPage(cars, pageable);
        List<Favorite> favorites=this.favoriteRepository.findAllFavoritesByUserId(userId);
        List<CarWithFavoriteDTO> carsWithFavorite=new ArrayList<CarWithFavoriteDTO>();
        this.userRepository.findById(userId)
        .orElseThrow(()->new ResourceNotFound("USER",userId));

        if(favorites.size()>0){
            for(CarDTO carDTO:carsDTO.getContent()){
                CarWithFavoriteDTO car=null;
                for(Favorite favorite:favorites){
                    if(favorite.getCar().getId()==carDTO.getId()){
                        car=new CarWithFavoriteDTO(carDTO, true, favorite.getId());
                        break;
                    }
                    else{
                        car=new CarWithFavoriteDTO(carDTO, false, 0L); 
                    }
                }
                carsWithFavorite.add(car);
            }
        }
        else{
            for(CarDTO carDTO:carsDTO.getContent()){
                CarWithFavoriteDTO car=new CarWithFavoriteDTO(carDTO, false, 0L);
                carsWithFavorite.add(car);
                car=null;
            }
        }
        return carsWithFavorite;
    }

    @Override
    public Car getById(Long id) {
        return this.carRepository.findById(id)
        .orElseThrow(()->new ResourceNotFound("CAR",id));
    }

    @Override
    public Car registerCar(Car car,Long ownerId) {
        Set<ConstraintViolation<Car>>violations=validator.validate(car);
        if(!violations.isEmpty()){
            throw new BadRequestException("CAR",violations);
        }
        User user=this.userRepository.findById(ownerId)
        .orElseThrow(()->new ResourceNotFound("USER",ownerId));
        car.setUser(user);

        List<Feature>features=car.getFeatures();
        features.forEach(feature->feature.setCar(car));
        
        List<Location>locations=car.getLocations();
        locations.forEach(location->location.setCar(car));

        car.setScore(0.0);

        return this.carRepository.save(car);
    }

    @Override
    public List<Car> getByUserId(Long ownerId) {
        return this.carRepository.findAllCarsByUserId(ownerId);
    }
    
}
