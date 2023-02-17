package com.api.parkingcontrolhexagonal.application.ports.output;

import com.api.parkingcontrolhexagonal.domain.model.ParkingSpot;
import com.api.parkingcontrolhexagonal.infrastucture.adapters.output.persistence.entity.ParkingSpotEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ParkingSpotOutputPort {
    ParkingSpot saveParkingSpot(ParkingSpot parkingSpot);
    void deleteParkingSpot(ParkingSpot parkingSpot);
    Optional<ParkingSpot> getParkingSpotById(UUID id);
    Optional<ParkingSpot> getParkingSpotByNumber(String parkingSpotNumber);
    List<ParkingSpotEntity> getParkingSpotByName(String name);
    List<ParkingSpotEntity> getAllParkingSpot();
}
