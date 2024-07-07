package com.terminator.services.producers;

import org.apache.kafka.common.header.internals.RecordHeaders;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.jboss.logging.Logger;

import com.github.javafaker.Faker;
import com.terminator.dtos.CountryDto;

import io.smallrye.reactive.messaging.kafka.api.OutgoingKafkaRecordMetadata;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CountryProducer {
    
    @Inject
    Logger logger;

    private Emitter<CountryDto> emitter;

    public CountryProducer(@Channel("countries-out") Emitter<CountryDto> emitter) {
        this.emitter = emitter;
    }

    public void produce() {
        logger.info("Producing a new message");
        Faker faker = new Faker();

        final var payload = CountryDto.builder()
                                        .name(faker.country().name())
                                        .build();
        // adding metadata to a message
        final var metadata = OutgoingKafkaRecordMetadata.builder()
                                    .withKey("some-key")
                                    .withHeaders(new RecordHeaders().add("correlation-key", "some-dummy-key".getBytes()))
                                    .build();

        emitter.send(Message.of(payload).addMetadata(metadata));
    }
}
