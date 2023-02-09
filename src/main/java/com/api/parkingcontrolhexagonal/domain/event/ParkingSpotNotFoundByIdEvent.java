package com.api.parkingcontrolhexagonal.domain.event;

import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSpotNotFoundByIdEvent {
    private UUID id;

    private LocalDateTime date;

    public ParkingSpotNotFoundByIdEvent(UUID id) {
        this.id = id;
        this.date = LocalDateTime.now();
    }

    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return date.format(formatter);
    }
}
