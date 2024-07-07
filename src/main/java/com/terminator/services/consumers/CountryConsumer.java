package com.terminator.services.consumers;

import java.util.concurrent.CompletionStage;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.jboss.logging.Logger;

import com.terminator.dtos.CountryDto;

import jakarta.inject.Inject;

public class CountryConsumer {

    @Inject
    Logger logger;
    
    @Incoming("countries-in")
    public CompletionStage<Void> consumeCountry(Message<CountryDto> message) {
        // A Message<T> contains a non-{@code null} payload, an acknowledgement function and a set of metadata.

        logger.infov("New incoming message: {0}", message.getPayload()); // we retrieve the message payload
        return message.ack(); // we excplicitly acknowledge the message
    }
}
