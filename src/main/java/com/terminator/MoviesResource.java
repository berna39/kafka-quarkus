package com.terminator;

import java.util.Random;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import com.github.javafaker.Faker;
import com.terminator.dtos.MovieDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("movies")
public class MoviesResource {
    
    private Emitter<MovieDto> emitter;

    public MoviesResource(@Channel("movies-out") Emitter<MovieDto> emitter) {
        this.emitter = emitter;
    }

    @GET
    @Path("/")
    public String produceMovie() {
        Faker faker = new Faker();
        emitter.send(MovieDto.builder()
                .title(faker.harryPotter().book())
                .synopsis(faker.lorem().paragraph(30))
                .views(new Random().nextInt(100000))
                .build());
        return "the movie has been produced";
    }
}
