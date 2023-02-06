package com.api.parkingcontrolhexagonal.infrastucture.adapters.input.rest;

import com.api.parkingcontrolhexagonal.application.ports.input.CreateParkingSpotUseCase;
import com.api.parkingcontrolhexagonal.application.ports.input.DeleteParkingSpotUseCase;
import com.api.parkingcontrolhexagonal.application.ports.input.GetParkingSpotUseCase;
import com.api.parkingcontrolhexagonal.application.ports.input.UpdateParkingSpotUseCase;
import com.api.parkingcontrolhexagonal.domain.model.ParkingSpot;
import com.api.parkingcontrolhexagonal.infrastructure.adapters.ParkingSpotApi;
import com.api.parkingcontrolhexagonal.infrastructure.adapters.data.ParkingSpotCreateRequest;
import com.api.parkingcontrolhexagonal.infrastructure.adapters.data.ParkingSpotCreateResponse;
import com.api.parkingcontrolhexagonal.infrastructure.adapters.data.ParkingSpotQueryResponse;
import com.api.parkingcontrolhexagonal.infrastucture.adapters.input.rest.mapper.ParkingSpotRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ParkingSpotRestAdapter implements ParkingSpotApi {
    private final CreateParkingSpotUseCase createParkingSpotUseCase;
    private final GetParkingSpotUseCase getParkingSpotUseCase;
    private final UpdateParkingSpotUseCase updateParkingSpotUseCase;
    private final DeleteParkingSpotUseCase deleteParkingSpotUseCase;
    private final ParkingSpotRestMapper parkingSpotRestMapper;


    @Override
    public ResponseEntity<ParkingSpotCreateResponse> createParkingSpot(@RequestBody @Valid ParkingSpotCreateRequest parkingSpotCreateRequest) {
        ParkingSpot parkingSpot = parkingSpotRestMapper.toParkingSpot(parkingSpotCreateRequest);

        parkingSpot = createParkingSpotUseCase.createParkingSpot(parkingSpot);

        return new ResponseEntity<>(parkingSpotRestMapper.toParkingSpotCreateResponse(parkingSpot), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ParkingSpotQueryResponse> getParkingSpot(@PathVariable UUID id){
        ParkingSpot parkingSpot = getParkingSpotUseCase.getParkingSpotById(id);
        return new ResponseEntity<>(parkingSpotRestMapper.toParkingSpotQueryResponse(parkingSpot), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getAllParkingSpots() {
        return ResponseEntity.status(HttpStatus.OK).body(getParkingSpotUseCase.getAllParkingSpot());
    }

    @Override
    public ResponseEntity<Object> updateParkingSpot(@PathVariable(value = "id") UUID id, @RequestBody @Valid ParkingSpotCreateRequest parkingSpotCreateRequest) {
        Optional<ParkingSpot> parkingSpotOptional = Optional.ofNullable(getParkingSpotUseCase.getParkingSpotById(id));
        ParkingSpot parkingSpot = parkingSpotRestMapper.toParkingSpot(parkingSpotCreateRequest);
        parkingSpot.setId(parkingSpotOptional.get().getId());
        parkingSpot = updateParkingSpotUseCase.updateParkingSpot(parkingSpot);
        return new ResponseEntity<>(parkingSpotRestMapper.toParkingSpotCreateResponse(parkingSpot), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> deleteParkingSpot(@PathVariable(value = "id") UUID id) {
        ParkingSpot parkingSpot = getParkingSpotUseCase.getParkingSpotById(id);
        deleteParkingSpotUseCase.deleteParkingSpot(parkingSpot);
        return ResponseEntity.status(HttpStatus.OK).body("Parking Spot deleted successfully");
    }
}
