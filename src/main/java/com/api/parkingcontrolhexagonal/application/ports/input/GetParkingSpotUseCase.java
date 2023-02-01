package com.api.parkingcontrolhexagonal.application.ports.input;

import com.api.parkingcontrolhexagonal.domain.model.ParkingSpot;

import java.util.UUID;

public interface GetParkingSpotUseCase {
    ParkingSpot getParkingSpotById(UUID id);
}
