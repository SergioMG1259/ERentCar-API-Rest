package com.OpenCrew.ERentCar.shared.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.OpenCrew.ERentCar.cars.application.mapper.CarMapper;
import com.OpenCrew.ERentCar.cars.application.mapper.FavoriteMapper;
import com.OpenCrew.ERentCar.cars.application.mapper.FeatureMapper;
import com.OpenCrew.ERentCar.cars.application.mapper.LocationMapper;
import com.OpenCrew.ERentCar.users.application.mapper.UserMapper;

@Configuration
public class MappingConfigration {
    @Bean
    public EnhancedModelMapper modelMapper(){return new EnhancedModelMapper();}
    @Bean
    public UserMapper userMapper(){return new UserMapper();}
    @Bean
    public CarMapper carMapper(){return new CarMapper();}
    @Bean
    public FeatureMapper featureMapper(){return new FeatureMapper();}
    @Bean
    public LocationMapper locationMapper(){return new LocationMapper();}
    @Bean
    public FavoriteMapper favoriteMapper(){return new FavoriteMapper();}
}
