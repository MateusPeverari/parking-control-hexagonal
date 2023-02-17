package com.api.parkingcontrolhexagonal.domain.event;

import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSpotNotFoundByNumberEvent {
    private String parkingSpotNumber;

    private LocalDateTime date;

    public ParkingSpotNotFoundByNumberEvent(String name) {
        this.parkingSpotNumber = name;
        this.date = LocalDateTime.now();
    }

    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return date.format(formatter);
    }
}
