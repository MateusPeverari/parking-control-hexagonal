package com.api.parkingcontrolhexagonal.infrastucture.adapters.output.persistence.repository;

import com.api.parkingcontrolhexagonal.infrastucture.adapters.output.persistence.entity.ParkingSpotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotEntity, UUID> {
    List<ParkingSpotEntity> findByResponsibleName(String name);

    Optional<ParkingSpotEntity> findByParkingSpotNumber(String number);
}
