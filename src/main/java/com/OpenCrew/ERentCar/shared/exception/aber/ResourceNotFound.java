package com.OpenCrew.ERentCar.shared.exception.aber;

public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound(String resourceName,  Long resourceId) {
        super(String.format("%s with id %d not found", resourceName, resourceId));
    }
}
