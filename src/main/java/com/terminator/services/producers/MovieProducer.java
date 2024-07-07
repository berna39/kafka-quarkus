package com.terminator.services.producers;

import java.util.Random;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;

import com.github.javafaker.Faker;
import com.terminator.dtos.MovieDto;

import jakarta.inject.Inject;

public class MovieProducer {

    @Inject
    Logger logger;

    private Emitter<MovieDto> emitter;

    public MovieProducer(@Channel("movies-out") Emitter<MovieDto> emitter) {
        this.emitter = emitter;
    }

    public void produce() {
        logger.info("Producing a new message");
        Faker faker = new Faker();
        emitter.send(MovieDto.builder()
                .title(faker.harryPotter().book())
                .synopsis(faker.lorem().paragraph(30))
                .views(new Random().nextInt(100000))
                .build());
    }
}
