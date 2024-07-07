package com.terminator.services.producers;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;

import com.github.javafaker.Faker;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class JokeProducer {

    @Inject
    Logger logger;
    
    @Channel("jokes-producer")
    Emitter<String> jokeEmitter;

    public void produce() {
        logger.info("Producing a new message");
        Faker faker = new Faker();
        jokeEmitter.send(faker.lorem().sentence(100));
        jokeEmitter.complete();
    }
}
