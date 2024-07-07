package com.terminator.services;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import com.terminator.dtos.MovieDto;

public class MovieConsumer {
    
    @Incoming("movies-in")
    public void produceMovie(MovieDto movie) {
        System.out.println(movie.toString());
    }
}
