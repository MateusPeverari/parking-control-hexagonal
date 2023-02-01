package com.api.parkingcontrolhexagonal.infrastucture.adapters.input.eventlistener;

import com.api.parkingcontrolhexagonal.domain.event.ParkingSpotCreatedEvent;
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
}
