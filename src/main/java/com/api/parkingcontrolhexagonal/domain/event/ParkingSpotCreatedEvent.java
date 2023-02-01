package com.api.parkingcontrolhexagonal.domain.event;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSpotCreatedEvent {
    private UUID id;

    private LocalDateTime date;

    public ParkingSpotCreatedEvent(UUID id) {
        this.id = id;
        this.date = LocalDateTime.now();
    }
}
