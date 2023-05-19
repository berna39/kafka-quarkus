package com.terminator;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import com.github.javafaker.Faker;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/jokes")
public class JokeResource {

    @Channel("jokes-producer")
    Emitter<String> jokeEmitter;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        Faker faker = new Faker();
        jokeEmitter.send(faker.lorem().sentence(100));
        return "Welcome to the show";
    }
}
