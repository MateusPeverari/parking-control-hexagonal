package com.api.parkingcontrolhexagonal.infrastucture.adapters.input.rest.data.response;

import lombok.*;



import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpotQueryResponse {
    private UUID id;
    private String parkingSpotNumber;
    private String licensePlateCar;
    private String brandCar;
    private String modelCar;
    private String colorCar;
    private String responsibleName;
    private String apartment;
    private String block;
}
