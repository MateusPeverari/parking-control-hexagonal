package com.api.parkingcontrolhexagonal.infrastucture.adapters.input.rest.mapper;

import com.api.parkingcontrolhexagonal.domain.model.ParkingSpot;
import com.api.parkingcontrolhexagonal.infrastructure.adapters.data.ParkingSpotCreateRequest;
import com.api.parkingcontrolhexagonal.infrastructure.adapters.data.ParkingSpotCreateResponse;
import com.api.parkingcontrolhexagonal.infrastructure.adapters.data.ParkingSpotQueryResponse;
import org.mapstruct.Mapper;

@Mapper
public interface ParkingSpotRestMapper {
    ParkingSpot toParkingSpot(ParkingSpotCreateRequest parkingSpotCreateRequest);
    ParkingSpotCreateResponse toParkingSpotCreateResponse(ParkingSpot parkingSpot);
    ParkingSpotQueryResponse toParkingSpotQueryResponse(ParkingSpot parkingSpot);
}
