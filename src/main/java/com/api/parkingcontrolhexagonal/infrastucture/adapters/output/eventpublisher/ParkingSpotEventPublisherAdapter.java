package com.api.parkingcontrolhexagonal.infrastucture.adapters.output.eventpublisher;

import com.api.parkingcontrolhexagonal.application.ports.output.ParkingSpotEventPublisher;
import com.api.parkingcontrolhexagonal.domain.event.*;
import org.springframework.context.ApplicationEventPublisher;

public class ParkingSpotEventPublisherAdapter implements ParkingSpotEventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;
    @Override
    public void publishParkingSpotCreatedEvent(ParkingSpotCreatedEvent event) {
        applicationEventPublisher.publishEvent(event);

    }

    @Override
    public void publishParkingSpotUpdatedEvent(ParkingSpotUpdatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

    @Override
    public void publishParkingSpotDeletedEvent(ParkingSpotDeletedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

    @Override
    public void publishParkingSpotNotCreatedEvent(ParkingSpotNotCreatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

    @Override
    public void publishParkingSpotNotFoundByIdEvent(ParkingSpotNotFoundByIdEvent event) {
        applicationEventPublisher.publishEvent(event);

    }

    @Override
    public void publishParkingSpotNotFoundByNameEvent(ParkingSpotNotFoundByNameEvent event) {
        applicationEventPublisher.publishEvent(event);

    }

    @Override
    public void publishParkingSpotNotFoundByNumberEvent(ParkingSpotNotFoundByNumberEvent event) {
        applicationEventPublisher.publishEvent(event);

    }

    public ParkingSpotEventPublisherAdapter(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
