package com.api.parkingcontrolhexagonal.application.ports.input;

import com.api.parkingcontrolhexagonal.domain.model.ParkingSpot;

import java.util.UUID;

public interface UpdateParkingSpotUseCase {
    ParkingSpot updateParkingSpot(ParkingSpot parkingSpot);
}
