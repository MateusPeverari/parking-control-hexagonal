package com.api.parkingcontrolhexagonal.application.ports.output;

import com.api.parkingcontrolhexagonal.domain.event.ParkingSpotCreatedEvent;

public interface ParkingSpotEventPublisher {
    void publishParkingSpotCreatedEvent(ParkingSpotCreatedEvent event);
}
