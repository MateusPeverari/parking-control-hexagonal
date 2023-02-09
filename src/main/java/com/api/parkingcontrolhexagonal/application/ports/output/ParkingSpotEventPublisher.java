package com.api.parkingcontrolhexagonal.application.ports.output;

import com.api.parkingcontrolhexagonal.domain.event.*;

public interface ParkingSpotEventPublisher {
    void publishParkingSpotCreatedEvent(ParkingSpotCreatedEvent event);
    void publishParkingSpotUpdatedEvent(ParkingSpotUpdatedEvent event);
    void publishParkingSpotDeletedEvent(ParkingSpotDeletedEvent event);
    void publishParkingSpotNotCreatedEvent(ParkingSpotNotCreatedEvent event);
    void publishParkingSpotNotFoundByIdEvent(ParkingSpotNotFoundByIdEvent event);
    void publishParkingSpotNotFoundByNameEvent(ParkingSpotNotFoundByNameEvent event);
}
