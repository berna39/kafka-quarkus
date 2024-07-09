package com.terminator.api;

import com.terminator.services.producers.BatchIndexProducer;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("batch")
public class BatchResource {
    
    @Inject
    BatchIndexProducer batchIndexProducer;

    @GET
    public String getIndex() {
        batchIndexProducer.produce();
        return "New index fetched and dispatched on the kafka topic";
    }
}
