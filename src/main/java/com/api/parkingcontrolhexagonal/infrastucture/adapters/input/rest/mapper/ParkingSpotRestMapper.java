package com.api.parkingcontrolhexagonal.infrastucture.adapters.input.rest.mapper;

import com.api.parkingcontrolhexagonal.domain.model.ParkingSpot;
import com.api.parkingcontrolhexagonal.infrastucture.adapters.input.rest.data.request.ParkingSpotCreateRequest;
import com.api.parkingcontrolhexagonal.infrastucture.adapters.input.rest.data.response.ParkingSpotCreateResponse;
import com.api.parkingcontrolhexagonal.infrastucture.adapters.input.rest.data.response.ParkingSpotQueryResponse;
import org.mapstruct.Mapper;

@Mapper
public interface ParkingSpotRestMapper {
    ParkingSpot toParkingSpot(ParkingSpotCreateRequest parkingSpotCreateRequest);
    ParkingSpotCreateResponse toParkingSpotCreateResponse(ParkingSpot parkingSpot);
    ParkingSpotQueryResponse toParkingSpotQueryResponse(ParkingSpot parkingSpot);
}
