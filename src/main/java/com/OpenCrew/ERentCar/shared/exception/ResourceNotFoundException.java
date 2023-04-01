package com.OpenCrew.ERentCar.shared.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException() { super(); }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(String resourceName, Long resourceId) {
        super(String.format("%s with id %d not found", resourceName, resourceId));
    }
}
