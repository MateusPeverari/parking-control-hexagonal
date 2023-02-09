package com.api.parkingcontrolhexagonal.application.ports.output;

import com.api.parkingcontrolhexagonal.domain.event.ParkingSpotCreatedEvent;
import com.api.parkingcontrolhexagonal.domain.event.ParkingSpotDeletedEvent;
import com.api.parkingcontrolhexagonal.domain.event.ParkingSpotUpdatedEvent;

public interface ParkingSpotEventPublisher {
    void publishParkingSpotCreatedEvent(ParkingSpotCreatedEvent event);
    void publishParkingSpotUpdatedEvent(ParkingSpotUpdatedEvent event);

    void publishParkingSpotDeletedEvent(ParkingSpotDeletedEvent event);
}
