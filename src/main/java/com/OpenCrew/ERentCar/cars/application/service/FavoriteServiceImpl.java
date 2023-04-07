package com.OpenCrew.ERentCar.cars.application.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.OpenCrew.ERentCar.cars.domain.model.Car;
import com.OpenCrew.ERentCar.cars.domain.model.Favorite;
import com.OpenCrew.ERentCar.cars.domain.repository.CarRepository;
import com.OpenCrew.ERentCar.cars.domain.repository.FavoriteRepository;
import com.OpenCrew.ERentCar.cars.domain.service.FavoriteService;
import com.OpenCrew.ERentCar.shared.exception.aber.ResourceNotFound;
import com.OpenCrew.ERentCar.users.domain.model.User;
import com.OpenCrew.ERentCar.users.domain.repository.UserRepository;

@Service
public class FavoriteServiceImpl implements FavoriteService{

    private final FavoriteRepository favoriteRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    public FavoriteServiceImpl(FavoriteRepository favoriteRepository, CarRepository carRepository,
    UserRepository userRepository) {
        this.favoriteRepository = favoriteRepository;
        this.carRepository = carRepository;
        this.userRepository=userRepository;
    }

    @Override
    public Favorite registerFavorite(Long carId, Long userId) {
        Car car=this.carRepository.findById(carId).orElseThrow(()->new ResourceNotFound("CAR",carId));
        User user=this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFound("USER",userId));
        Favorite favorite=new Favorite();
        favorite.setCar(car);
        favorite.setUser(user);
        return this.favoriteRepository.save(favorite);
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        // TODO Auto-generated method stub
        return this.favoriteRepository.findById(id).map(favorite -> {
            this.favoriteRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFound("FAVORITE", id));
    }

    @Override
    public Page<Favorite> getByUserId(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByUserId'");
    }
    
}
