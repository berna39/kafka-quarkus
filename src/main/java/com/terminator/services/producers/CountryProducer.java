package com.terminator.services.producers;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;

import com.github.javafaker.Faker;
import com.terminator.dtos.CountryDto;

import io.smallrye.reactive.messaging.kafka.Record;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CountryProducer {
    
    @Inject
    Logger logger;

    private Emitter<Record<String, CountryDto>> emitter;

    public CountryProducer(@Channel("countries-out") Emitter<Record<String, CountryDto>> emitter) {
        this.emitter = emitter;
    }

    public void produce() {
        logger.info("Producing a new message");
        Faker faker = new Faker();
        emitter.send(Record.of("id-2349023423424", CountryDto.builder()
                                                                    .name(faker.country().name())
                                                                    .build()));
    }
}
