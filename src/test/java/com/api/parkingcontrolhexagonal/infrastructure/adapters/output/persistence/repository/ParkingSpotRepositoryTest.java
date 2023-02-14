package com.api.parkingcontrolhexagonal.infrastructure.adapters.output.persistence.repository;

import com.api.parkingcontrolhexagonal.ParkingControlHexagonalApplication;
import com.api.parkingcontrolhexagonal.domain.model.ParkingSpot;
import com.api.parkingcontrolhexagonal.infrastucture.adapters.output.persistence.entity.ParkingSpotEntity;
import com.api.parkingcontrolhexagonal.infrastucture.adapters.output.persistence.mapper.ParkingSpotPersistenceMapper;
import com.api.parkingcontrolhexagonal.infrastucture.adapters.output.persistence.repository.ParkingSpotRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@Sql(scripts="classpath:populate.sql")
@SpringBootTest(classes = ParkingControlHexagonalApplication.class)
@Transactional
class ParkingSpotRepositoryTest {

    @Autowired
    protected ParkingSpotRepository parkingSpotRepository;

    @Autowired
    protected ParkingSpotPersistenceMapper parkingSpotPersistenceMapper;
    @Test
    void getAllParkingSpots() {
        var result = parkingSpotRepository.findAll();

        assertEquals(3, result.size());
    }

    @Test
    void findParkingSpotByName() {
        List<ParkingSpotEntity> result = parkingSpotRepository.findByResponsibleName("John Doe");

        assertEquals(result.size(), 1);
    }

    @Test
    void findParkingSpotById() {
        UUID id = UUID.fromString("190e0f71-9b44-46c8-8e30-5913a22b2446");
        Optional<ParkingSpotEntity> parkingSpotEntity = parkingSpotRepository.findById(id);
        ParkingSpot result = parkingSpotPersistenceMapper.toParkingSpot(parkingSpotEntity.get());

        assertEquals(result.getResponsibleName(), "Jane Doe");
    }
}
