package com.api.parkingcontrolhexagonal.infrastucture.adapters.input.rest.data.request;

import lombok.AllArgsConstructor;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpotCreateRequest {
    @NotEmpty(message = "Parking spot number must not be empty!")
    private String parkingSpotNumber;

    @NotEmpty(message = "License plate car must not be empty!")
    private String licensePlateCar;

    @NotEmpty(message = "Car brand must not be empty!")
    private String brandCar;

    @NotEmpty(message = "Car model must not be empty!")
    private String modelCar;

    @NotEmpty(message = "Car color must not be empty!")
    private String colorCar;

    @NotEmpty(message = "Responsible name must not be empty!")
    private String responsibleName;

    @NotEmpty(message = "Apartment name must not be empty!")
    private String apartment;

    @NotEmpty(message = "Block name must not be empty!")
    private String block;
}
