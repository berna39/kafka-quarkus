package com.terminator.services.consumers;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import com.terminator.dtos.MovieDto;

import jakarta.inject.Inject;

public class MovieConsumer {

    @Inject
    Logger logger;
    
    @Incoming("movies-in")
    public void produceMovie(MovieDto movie) {
        logger.infov("New incoming message: {0}", movie.toString());
    }
}
