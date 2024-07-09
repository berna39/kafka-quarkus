package com.terminator.services.producers;

import java.util.Random;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;

import jakarta.inject.Inject;

public class BatchIndexProducer {

    @Inject
    Logger logger;

    @Channel("batch-producer")
    private Emitter<Double> emitter;

     public void produce() {
        final var index = fetchIndexesFromDataSource();
        emitter.send(index);
     }

     private Double fetchIndexesFromDataSource() {
        return new Random().nextDouble();
     }
}
