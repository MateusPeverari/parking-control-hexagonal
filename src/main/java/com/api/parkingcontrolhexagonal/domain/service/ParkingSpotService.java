package com.api.parkingcontrolhexagonal.domain.service;

import com.api.parkingcontrolhexagonal.application.ports.input.CreateParkingSpotUseCase;
import com.api.parkingcontrolhexagonal.application.ports.input.DeleteParkingSpotUseCase;
import com.api.parkingcontrolhexagonal.application.ports.input.GetParkingSpotUseCase;
import com.api.parkingcontrolhexagonal.application.ports.input.UpdateParkingSpotUseCase;
import com.api.parkingcontrolhexagonal.application.ports.output.ParkingSpotEventPublisher;
import com.api.parkingcontrolhexagonal.application.ports.output.ParkingSpotOutputPort;
import com.api.parkingcontrolhexagonal.domain.event.*;
import com.api.parkingcontrolhexagonal.domain.exception.DuplicateRegister;
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
        try {
            parkingSpot = parkingSpotOutputPort.saveParkingSpot(parkingSpot);
            parkingSpotEventPublisher.publishParkingSpotCreatedEvent(new ParkingSpotCreatedEvent(parkingSpot.getId()));
            return parkingSpot;
        } catch (Exception e) {
            parkingSpotEventPublisher.publishParkingSpotNotCreatedEvent(new ParkingSpotNotCreatedEvent(parkingSpot.getId()));
            throw new DuplicateRegister("Duplicated registers");
        }
    }

    @Override
    public ParkingSpot getParkingSpotById(UUID id) {
        if (parkingSpotOutputPort.getParkingSpotById(id).isEmpty()) {
            parkingSpotEventPublisher.publishParkingSpotNotFoundByIdEvent(new ParkingSpotNotFoundByIdEvent(id));
            throw new ParkingSpotNotFound("Parking Spot not found with id: " + id);
        } else {
            return parkingSpotOutputPort.getParkingSpotById(id).orElseThrow(() -> new ParkingSpotNotFound("Parking Spot not found with id: " + id));
        }
    }

    @Override
    public ParkingSpot getParkingSpotByNumber(String parkingSpotNumber) {
        if (parkingSpotOutputPort.getParkingSpotByNumber(parkingSpotNumber).isEmpty()) {
            parkingSpotEventPublisher.publishParkingSpotNotFoundByNumberEvent(new ParkingSpotNotFoundByNumberEvent(parkingSpotNumber));
            throw new ParkingSpotNotFound("Parking Spot not found with number: " + parkingSpotNumber);
        } else {
            return parkingSpotOutputPort.getParkingSpotByNumber(parkingSpotNumber).orElseThrow(() -> new ParkingSpotNotFound("Parking Spot not found with number: " + parkingSpotNumber));
        }
    }

    @Override
    public List<ParkingSpotEntity> getParkingSpotByName(String name) {
        if (parkingSpotOutputPort.getParkingSpotByName(name).isEmpty()) {
            parkingSpotEventPublisher.publishParkingSpotNotFoundByNameEvent(new ParkingSpotNotFoundByNameEvent(name));
            throw new ParkingSpotNotFound("No Parking Spots found with responsible name: " + name);
        } else {
            return parkingSpotOutputPort.getParkingSpotByName(name);
        }

    }

    @Override
    public List<ParkingSpotEntity> getAllParkingSpot() {
        return parkingSpotOutputPort.getAllParkingSpot();
    }
    @Override
    public ParkingSpot updateParkingSpot(ParkingSpot parkingSpot) {
        parkingSpot = parkingSpotOutputPort.saveParkingSpot(parkingSpot);
        parkingSpotEventPublisher.publishParkingSpotUpdatedEvent(new ParkingSpotUpdatedEvent(parkingSpot.getId()));
        return parkingSpot;
    }

    @Override
    public void deleteParkingSpot(ParkingSpot parkingSpot) {
        parkingSpotOutputPort.deleteParkingSpot(parkingSpot);
        parkingSpotEventPublisher.publishParkingSpotDeletedEvent(new ParkingSpotDeletedEvent(parkingSpot.getId()));
    }
}
