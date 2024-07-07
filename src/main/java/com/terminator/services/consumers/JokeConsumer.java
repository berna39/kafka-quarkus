package com.terminator.services.consumers;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import jakarta.inject.Inject;

public class JokeConsumer {

    @Inject
    Logger logger;
    
    @Incoming("jokes-consumer")
    public void process(String joke) {
        logger.infov("New incoming message: {0}", joke);
    }
}
