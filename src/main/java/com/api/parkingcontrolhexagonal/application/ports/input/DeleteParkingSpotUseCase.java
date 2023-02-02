package com.api.parkingcontrolhexagonal.application.ports.input;

import com.api.parkingcontrolhexagonal.domain.model.ParkingSpot;

public interface DeleteParkingSpotUseCase {
    void deleteParkingSpot(ParkingSpot parkingSpot);

}
