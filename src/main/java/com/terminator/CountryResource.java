package com.terminator;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import com.github.javafaker.Faker;
import com.terminator.dtos.CountryDto;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;


@Path("countries")
public class CountryResource {
    
    private Emitter<CountryDto> emitter;

    public CountryResource(@Channel("countries-out") Emitter<CountryDto> emitter){
        this.emitter = emitter;
    }

    @GET
    @Path("/")
    public String produceCountry(){
        Faker faker = new Faker();
        emitter.send(CountryDto.builder().name(faker.country().name()).build());
        return "The country has been produced";
    }
}
