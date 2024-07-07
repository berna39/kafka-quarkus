package com.terminator;

import com.terminator.services.producers.CountryProducer;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("countries")
public class CountryResource {
    
    @Inject
    CountryProducer producer;

    @GET
    @Path("/")
    public String produceCountry() {
        producer.produce();
        return "The country has been produced";
    }
}
