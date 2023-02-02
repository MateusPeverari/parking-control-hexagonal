package com.api.parkingcontrolhexagonal.application.ports.output;

import com.api.parkingcontrolhexagonal.domain.model.ParkingSpot;

import java.util.Optional;
import java.util.UUID;

public interface ParkingSpotOutputPort {
    ParkingSpot saveParkingSpot(ParkingSpot parkingSpot);
    void deleteParkingSpot(ParkingSpot parkingSpot);
    Optional<ParkingSpot> getParkingSpotById(UUID id);
}
