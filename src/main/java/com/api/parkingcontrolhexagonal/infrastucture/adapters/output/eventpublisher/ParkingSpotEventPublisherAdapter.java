package com.api.parkingcontrolhexagonal.infrastucture.adapters.output.eventpublisher;

import com.api.parkingcontrolhexagonal.application.ports.output.ParkingSpotEventPublisher;
import com.api.parkingcontrolhexagonal.domain.event.ParkingSpotCreatedEvent;
import org.springframework.context.ApplicationEventPublisher;

public class ParkingSpotEventPublisherAdapter implements ParkingSpotEventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;
    @Override
    public void publishParkingSpotCreatedEvent(ParkingSpotCreatedEvent event) {
        applicationEventPublisher.publishEvent(event);

    }

    public ParkingSpotEventPublisherAdapter(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
