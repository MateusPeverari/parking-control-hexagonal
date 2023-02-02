package com.api.parkingcontrolhexagonal.infrastucture.adapters.input.rest;

import com.api.parkingcontrolhexagonal.application.ports.input.CreateParkingSpotUseCase;
import com.api.parkingcontrolhexagonal.application.ports.input.DeleteParkingSpotUseCase;
import com.api.parkingcontrolhexagonal.application.ports.input.GetParkingSpotUseCase;
import com.api.parkingcontrolhexagonal.application.ports.input.UpdateParkingSpotUseCase;
import com.api.parkingcontrolhexagonal.domain.model.ParkingSpot;
import com.api.parkingcontrolhexagonal.infrastucture.adapters.input.rest.data.request.ParkingSpotCreateRequest;
import com.api.parkingcontrolhexagonal.infrastucture.adapters.input.rest.data.response.ParkingSpotCreateResponse;
import com.api.parkingcontrolhexagonal.infrastucture.adapters.input.rest.data.response.ParkingSpotQueryResponse;
import com.api.parkingcontrolhexagonal.infrastucture.adapters.input.rest.mapper.ParkingSpotRestMapper;
import com.api.parkingcontrolhexagonal.infrastucture.adapters.output.persistence.entity.ParkingSpotEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/parking-spot")
@RequiredArgsConstructor
public class ParkingSpotRestAdapter {
    private final CreateParkingSpotUseCase createParkingSpotUseCase;
    private final GetParkingSpotUseCase getParkingSpotUseCase;
    private final UpdateParkingSpotUseCase updateParkingSpotUseCase;
    private final DeleteParkingSpotUseCase deleteParkingSpotUseCase;
    private final ParkingSpotRestMapper parkingSpotRestMapper;

    @PostMapping()
    public ResponseEntity<ParkingSpotCreateResponse> createParkingSpot(@RequestBody @Valid ParkingSpotCreateRequest parkingSpotCreateRequest) {
        ParkingSpot parkingSpot = parkingSpotRestMapper.toParkingSpot(parkingSpotCreateRequest);

        parkingSpot = createParkingSpotUseCase.createParkingSpot(parkingSpot);

        return new ResponseEntity<>(parkingSpotRestMapper.toParkingSpotCreateResponse(parkingSpot), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingSpotQueryResponse> getParkingSpot(@PathVariable UUID id){
        ParkingSpot parkingSpot = getParkingSpotUseCase.getParkingSpotById(id);
        return new ResponseEntity<>(parkingSpotRestMapper.toParkingSpotQueryResponse(parkingSpot), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateParkingSpot(@PathVariable(value = "id") UUID id, @RequestBody @Valid ParkingSpotCreateRequest parkingSpotCreateRequest) {
        Optional<ParkingSpot> parkingSpotOptional = Optional.ofNullable(getParkingSpotUseCase.getParkingSpotById(id));
        ParkingSpot parkingSpot = parkingSpotRestMapper.toParkingSpot(parkingSpotCreateRequest);
        parkingSpot.setId(parkingSpotOptional.get().getId());
        parkingSpot = updateParkingSpotUseCase.updateParkingSpot(parkingSpot);
        return new ResponseEntity<>(parkingSpotRestMapper.toParkingSpotCreateResponse(parkingSpot), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteParkingSpot(@PathVariable(value = "id") UUID id) {
        ParkingSpot parkingSpot = getParkingSpotUseCase.getParkingSpotById(id);
        deleteParkingSpotUseCase.deleteParkingSpot(parkingSpot);
        return ResponseEntity.status(HttpStatus.OK).body("Parking Spot deleted successfully");
    }
}
