package com.terminator;

import com.terminator.services.producers.MovieProducer;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("movies")
public class MoviesResource {

    @Inject
    MovieProducer producer;

    @GET
    @Path("/")
    public String produceMovie() {
        producer.produce();
        return "the movie has been produced";
    }
}
