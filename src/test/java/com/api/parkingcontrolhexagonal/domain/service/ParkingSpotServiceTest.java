package com.api.parkingcontrolhexagonal.domain.service;

import com.api.parkingcontrolhexagonal.ParkingControlHexagonalApplication;
import com.api.parkingcontrolhexagonal.domain.exception.ParkingSpotNotFound;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@Sql(scripts="classpath:populate.sql")
@SpringBootTest(classes = ParkingControlHexagonalApplication.class)
@Transactional
public class ParkingSpotServiceTest {
    @Autowired
    private ParkingSpotService parkingSpotService;
    @Test
    void getParkingSpotById() {
        UUID id = UUID.fromString("190e0f71-9b44-46c8-8e30-5913a22b2446");

        var result = parkingSpotService.getParkingSpotById(id);
        assertEquals("11A", result.getParkingSpotNumber());
    }

    @Test
    void getParkingSpotByIdNotFound() {
        UUID id = UUID.fromString("190e0f71-9b44-46c8-8e30-5913a22b2222");

        assertThrows(ParkingSpotNotFound.class, () -> {
            parkingSpotService.getParkingSpotById(id);
        });
    }

    @Test
    void getParkingSpotByName() {
        var result = parkingSpotService.getParkingSpotByName("John Doe");

        assertEquals(result.size(), 1);
    }

    @Test
    void getParkingSpotByNameNotFound() {
        assertThrows(ParkingSpotNotFound.class, () -> {
            parkingSpotService.getParkingSpotByName("Aaaa");
        });
    }
    @Test
    void getParkingSpotByNumber() {
        var result = parkingSpotService.getParkingSpotByNumber("54B");

        assertEquals("Porsche", result.getBrandCar());
    }

    @Test
    void getParkingSpotByNumberNotFound() {
        assertThrows(ParkingSpotNotFound.class, () -> {
            parkingSpotService.getParkingSpotByNumber("132B");
        });
    }

    @Test
    void getAllParkingSpots() {
        var result = parkingSpotService.getAllParkingSpot();

        assertEquals(result.size(), 3);
    }

    @Test
    void deleteParkingSpotNotFound() {
        UUID id = UUID.fromString("190e0f71-9b44-46c8-8e30-5913a22b2555");

        assertThrows(ParkingSpotNotFound.class, () -> {
            parkingSpotService.deleteParkingSpot(parkingSpotService.getParkingSpotById(id));
        });
    }

    @Test
    void deleteParkingSpot() {
        UUID id = UUID.fromString("190e0f71-9b44-46c8-8e30-5913a22b2446");
        parkingSpotService.deleteParkingSpot(parkingSpotService.getParkingSpotById(id));

        var result = parkingSpotService.getAllParkingSpot();

        assertEquals(result.size(), 2);
    }
}
