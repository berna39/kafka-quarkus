package com.terminator.services;

import java.util.concurrent.CompletionStage;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

import com.terminator.dtos.CountryDto;

public class CountryConsumer {
    
    @Incoming("countries-in")
    public CompletionStage<Void> consumeCountry(Message<CountryDto> message){
        System.out.println("------------------ New Country --------------");
        System.out.println(message.getPayload()); // we retrieve the message peyload
        return message.ack();
    }
}
