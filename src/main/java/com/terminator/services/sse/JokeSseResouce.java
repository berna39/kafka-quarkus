package com.terminator.services.sse;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.jboss.resteasy.reactive.RestStreamElementType;

import com.terminator.dtos.CountryDto;

import io.smallrye.mutiny.Multi;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("sse/countries")
public class JokeSseResouce {
    
    @jakarta.inject.Inject
    @Channel("countries")
    Multi<CountryDto> countriesStream;

    @GET
    @RestStreamElementType(MediaType.TEXT_PLAIN)
    public Multi<CountryDto> stream() {
        return countriesStream;
    }
}
