package com.api.parkingcontrolhexagonal.application.ports.input;

import com.api.parkingcontrolhexagonal.domain.model.ParkingSpot;
import com.api.parkingcontrolhexagonal.infrastucture.adapters.output.persistence.entity.ParkingSpotEntity;

import java.util.List;
import java.util.UUID;

public interface GetParkingSpotUseCase {
    ParkingSpot getParkingSpotById(UUID id);
    List<ParkingSpotEntity> getAllParkingSpot();
}
