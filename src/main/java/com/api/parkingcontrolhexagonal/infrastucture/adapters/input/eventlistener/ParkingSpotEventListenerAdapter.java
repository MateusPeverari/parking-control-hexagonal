package com.api.parkingcontrolhexagonal.infrastucture.adapters.input.eventlistener;

import com.api.parkingcontrolhexagonal.domain.event.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ParkingSpotEventListenerAdapter {
    @EventListener
    public void handle(ParkingSpotCreatedEvent event) {
        log.info("Parking spot created with id " + event.getId() + " at " + event.getDate());
    }

    @EventListener
    public void handle(ParkingSpotUpdatedEvent event) {
        log.info("Parking spot updated with id " + event.getId() + " at " + event.getDate());
    }

    @EventListener
    public void handle(ParkingSpotDeletedEvent event) {
        log.info("Parking spot deleted with id " + event.getId() + " at " + event.getDate());
    }

    @EventListener
    public void handle(ParkingSpotNotCreatedEvent event) {
        log.warn("Parking spot could not be created because of duplicate registers at " + event.getDate());
    }

    @EventListener
    public void handle(ParkingSpotNotFoundByIdEvent event) {
        log.info("Parking spot could not be found with id " + event.getId() + " at " + event.getDate());
    }

    @EventListener
    public void handle(ParkingSpotNotFoundByNameEvent event) {
        log.info("Parking spot could not be found with name " + event.getName() + " at " + event.getDate());
    }
}
