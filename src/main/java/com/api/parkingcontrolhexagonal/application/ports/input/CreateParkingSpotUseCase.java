package com.api.parkingcontrolhexagonal.application.ports.input;

import com.api.parkingcontrolhexagonal.domain.model.ParkingSpot;

public interface CreateParkingSpotUseCase {
    ParkingSpot createParkingSpot(ParkingSpot parkingSpot);
}
