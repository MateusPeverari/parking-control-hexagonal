package com.api.parkingcontrolhexagonal.infrastucture.adapters.output.persistence;

import com.api.parkingcontrolhexagonal.application.ports.output.ParkingSpotOutputPort;
import com.api.parkingcontrolhexagonal.domain.model.ParkingSpot;
import com.api.parkingcontrolhexagonal.infrastucture.adapters.output.persistence.entity.ParkingSpotEntity;
import com.api.parkingcontrolhexagonal.infrastucture.adapters.output.persistence.mapper.ParkingSpotPersistenceMapper;
import com.api.parkingcontrolhexagonal.infrastucture.adapters.output.persistence.repository.ParkingSpotRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class ParkingSpotPersistenceAdapter implements ParkingSpotOutputPort {
    private final ParkingSpotRepository parkingSpotRepository;
    private final ParkingSpotPersistenceMapper parkingSpotPersistenceMapper;

    @Override
    public ParkingSpot saveParkingSpot(ParkingSpot parkingSpot) {
        ParkingSpotEntity parkingSpotEntity = parkingSpotPersistenceMapper.toParkingSpotEntity(parkingSpot);
        parkingSpotEntity = parkingSpotRepository.save(parkingSpotEntity);
        return parkingSpotPersistenceMapper.toParkingSpot(parkingSpotEntity);
    }

    @Override
    public void deleteParkingSpot(ParkingSpot parkingSpot) {
        ParkingSpotEntity parkingSpotEntity = parkingSpotPersistenceMapper.toParkingSpotEntity(parkingSpot);
        parkingSpotRepository.delete(parkingSpotEntity);
    }

    @Override
    public Optional<ParkingSpot> getParkingSpotById(UUID id) {
        Optional<ParkingSpotEntity> parkingSpotEntity = parkingSpotRepository.findById(id);

        if (parkingSpotEntity.isEmpty()) {
            return Optional.empty();
        }

        ParkingSpot parkingSpot = parkingSpotPersistenceMapper.toParkingSpot(parkingSpotEntity.get());
        return Optional.of(parkingSpot);
    }

}
