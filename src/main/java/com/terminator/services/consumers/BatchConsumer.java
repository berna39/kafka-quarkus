package com.terminator.services.consumers;

import java.util.List;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import jakarta.inject.Inject;

public class BatchConsumer {
    
    @Inject
    Logger logger;

    @Incoming("batch-consumer")
    public void consume(List<Double> indexes) {
        logger.infov("New incoming indexes {0}", indexes);
    }
}
