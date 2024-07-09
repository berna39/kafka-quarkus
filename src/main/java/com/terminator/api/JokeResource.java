package com.terminator.api;

import com.terminator.services.producers.JokeProducer;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("jokes")
public class JokeResource {

    @Inject
    JokeProducer producer;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        producer.produce();
        return "Welcome to the show";
    }
}
