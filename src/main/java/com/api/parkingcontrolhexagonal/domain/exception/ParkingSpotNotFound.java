package com.api.parkingcontrolhexagonal.domain.exception;

public class ParkingSpotNotFound extends RuntimeException {
    public ParkingSpotNotFound(String message) {
        super(message);
    }
}
