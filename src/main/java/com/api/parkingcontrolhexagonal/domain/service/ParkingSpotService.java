package com.api.parkingcontrolhexagonal.domain.service;

import com.api.parkingcontrolhexagonal.application.ports.input.CreateParkingSpotUseCase;
import com.api.parkingcontrolhexagonal.application.ports.input.DeleteParkingSpotUseCase;
import com.api.parkingcontrolhexagonal.application.ports.input.GetParkingSpotUseCase;
import com.api.parkingcontrolhexagonal.application.ports.input.UpdateParkingSpotUseCase;
import com.api.parkingcontrolhexagonal.application.ports.output.ParkingSpotEventPublisher;
import com.api.parkingcontrolhexagonal.application.ports.output.ParkingSpotOutputPort;
import com.api.parkingcontrolhexagonal.domain.event.ParkingSpotCreatedEvent;
import com.api.parkingcontrolhexagonal.domain.exception.ParkingSpotNotFound;
import com.api.parkingcontrolhexagonal.domain.model.ParkingSpot;
import com.api.parkingcontrolhexagonal.infrastucture.adapters.output.persistence.entity.ParkingSpotEntity;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class ParkingSpotService implements GetParkingSpotUseCase, CreateParkingSpotUseCase, UpdateParkingSpotUseCase, DeleteParkingSpotUseCase {
    private final ParkingSpotOutputPort parkingSpotOutputPort;

    private final ParkingSpotEventPublisher parkingSpotEventPublisher;

    @Override
    public ParkingSpot createParkingSpot(ParkingSpot parkingSpot) {
        parkingSpot = parkingSpotOutputPort.saveParkingSpot(parkingSpot);
        parkingSpotEventPublisher.publishParkingSpotCreatedEvent(new ParkingSpotCreatedEvent(parkingSpot.getId()));
        return parkingSpot;
    }

    @Override
    public ParkingSpot getParkingSpotById(UUID id) {
        return parkingSpotOutputPort.getParkingSpotById(id).orElseThrow(() -> new ParkingSpotNotFound("Parking Spot not found with id: " + id));
    }

    @Override
    public ParkingSpot getParkingSpotByName(String name) {
        return parkingSpotOutputPort.getParkingSpotByName(name).orElseThrow(() -> new ParkingSpotNotFound("Parking Spot not found with name: " + name));

    }

    @Override
    public List<ParkingSpotEntity> getAllParkingSpot() {
        return parkingSpotOutputPort.getAllParkingSpot();
    }
    @Override
    public ParkingSpot updateParkingSpot(ParkingSpot parkingSpot) {
        parkingSpot = parkingSpotOutputPort.saveParkingSpot(parkingSpot);
        parkingSpotEventPublisher.publishParkingSpotCreatedEvent(new ParkingSpotCreatedEvent(parkingSpot.getId()));
        return parkingSpot;
    }

    @Override
    public void deleteParkingSpot(ParkingSpot parkingSpot) {
        parkingSpotOutputPort.deleteParkingSpot(parkingSpot);
    }
}
