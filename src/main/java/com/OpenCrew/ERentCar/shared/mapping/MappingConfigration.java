package com.OpenCrew.ERentCar.shared.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.OpenCrew.ERentCar.users.application.mapper.UserMapper;

@Configuration
public class MappingConfigration {
    @Bean
    public EnhancedModelMapper modelMapper(){return new EnhancedModelMapper();}
    @Bean
    public UserMapper userMapper(){return new UserMapper();}
}
