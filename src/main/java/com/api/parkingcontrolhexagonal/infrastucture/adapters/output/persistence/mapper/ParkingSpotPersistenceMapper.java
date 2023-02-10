package com.api.parkingcontrolhexagonal.infrastucture.adapters.output.persistence.mapper;

import com.api.parkingcontrolhexagonal.domain.model.ParkingSpot;
import com.api.parkingcontrolhexagonal.infrastucture.adapters.output.persistence.entity.ParkingSpotEntity;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper
public interface ParkingSpotPersistenceMapper {
    ParkingSpotEntity toParkingSpotEntity(ParkingSpot parkingSpot);

    ParkingSpot toParkingSpot(ParkingSpotEntity parkingSpotEntity);

}
