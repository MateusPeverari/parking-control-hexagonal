package com.api.parkingcontrolhexagonal.infrastructure.adapters.input.rest;

import com.api.parkingcontrolhexagonal.ParkingControlHexagonalApplication;
import com.api.parkingcontrolhexagonal.domain.exception.ParkingSpotNotFound;
import com.api.parkingcontrolhexagonal.infrastucture.adapters.input.rest.ParkingSpotRestAdapter;
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
public class ParkingSpotRestAdapterTest {
    @Autowired
    ParkingSpotRestAdapter parkingSpotRestAdapter;

    @Test
    void getParkingSpotById() {
        UUID id = UUID.fromString("190e0f71-9b44-46c8-8e30-5913a22b2446");
        var result = parkingSpotRestAdapter.getParkingSpot(id);

        assertEquals(result.getStatusCodeValue(), 200);
    }

    @Test
    void getParkingSpotByIdNotFound() {
        UUID id = UUID.fromString("190e0f71-9b44-46c8-8e30-5913a22b2555");

        assertThrows(ParkingSpotNotFound.class, () -> {
            parkingSpotRestAdapter.getParkingSpot(id);
        });
    }

    @Test
    void deleteParkingSpot() {
        UUID id = UUID.fromString("190e0f71-9b44-46c8-8e30-5913a22b2446");
        var result = parkingSpotRestAdapter.deleteParkingSpot(id);

        assertEquals(result.getStatusCodeValue(), 200);
    }

    @Test
    void deleteParkingSpotNotFound() {
        UUID id = UUID.fromString("190e0f71-9b44-46c8-8e30-5913a22b2555");

        assertThrows(ParkingSpotNotFound.class, () -> {
            parkingSpotRestAdapter.deleteParkingSpot(id);
        });
    }

    @Test
    void getParkingSpotByName() {
        var result = parkingSpotRestAdapter.getParkingSpotByName("John Doe");

        assertEquals(result.getStatusCodeValue(), 200);
    }

    @Test
    void getParkingSpotByNameNotFound() {
        assertThrows(ParkingSpotNotFound.class, () -> {
            parkingSpotRestAdapter.getParkingSpotByName("Aaaa");
        });
    }

    @Test
    void getAllParkingSpots() {
        var result = parkingSpotRestAdapter.getAllParkingSpots();

        assertEquals(result.getStatusCodeValue(), 200);
    }

    @Test
    void getParkingSpotByNumber() {
        var result = parkingSpotRestAdapter.getParkingSpotByNumber("122B");

        assertEquals(result.getStatusCodeValue(), 200);
    }

    @Test
    void getParkingSpotByNumberNotFound() {
        assertThrows(ParkingSpotNotFound.class, () -> {
            parkingSpotRestAdapter.getParkingSpotByNumber("23A");
        });
    }
}
