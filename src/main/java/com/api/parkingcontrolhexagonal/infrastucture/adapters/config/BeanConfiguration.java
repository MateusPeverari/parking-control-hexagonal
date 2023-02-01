package com.api.parkingcontrolhexagonal.infrastucture.adapters.config;

import com.api.parkingcontrolhexagonal.domain.service.ParkingSpotService;
import com.api.parkingcontrolhexagonal.infrastucture.adapters.output.eventpublisher.ParkingSpotEventPublisherAdapter;
import com.api.parkingcontrolhexagonal.infrastucture.adapters.output.persistence.ParkingSpotPersistenceAdapter;
import com.api.parkingcontrolhexagonal.infrastucture.adapters.output.persistence.mapper.ParkingSpotPersistenceMapper;
import com.api.parkingcontrolhexagonal.infrastucture.adapters.output.persistence.repository.ParkingSpotRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ParkingSpotPersistenceAdapter parkingSpotPersistenceAdapter(ParkingSpotRepository parkingSpotRepository, ParkingSpotPersistenceMapper parkingSpotPersistenceMapper) {
        return new ParkingSpotPersistenceAdapter(parkingSpotRepository, parkingSpotPersistenceMapper);
    }

    @Bean
    public ParkingSpotEventPublisherAdapter parkingSpotEventPublisherAdapter(ApplicationEventPublisher applicationEventPublisher) {
        return new ParkingSpotEventPublisherAdapter(applicationEventPublisher);
    }

    @Bean
    public ParkingSpotService parkingSpotService(ParkingSpotPersistenceAdapter parkingSpotPersistenceAdapter, ParkingSpotEventPublisherAdapter parkingSpotEventPublisherAdapter) {
        return new ParkingSpotService(parkingSpotPersistenceAdapter, parkingSpotEventPublisherAdapter);
    }
}
