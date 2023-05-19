package com.terminator.service;

import org.eclipse.microprofile.reactive.messaging.Incoming;

public class JokeConsumer {
    
    @Incoming("jokes-consumer")
    public void process(String joke){
        System.out.println(joke);
    }
}
