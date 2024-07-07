package com.terminator.services.consumers;

import java.util.concurrent.CompletionStage;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.jboss.logging.Logger;

import com.terminator.dtos.CountryDto;

import io.smallrye.reactive.messaging.kafka.Record;
import jakarta.inject.Inject;

public class CountryConsumer {

    @Inject
    Logger logger;
    
    @Incoming("countries-in")
    public CompletionStage<Void> consumeCountry(Message<CountryDto> message) {
        // A Message<T> contains a non-{@code null} payload, an acknowledgement function and a set of metadata.

        logger.infov("New incoming message: {0}", message.getPayload()); // we retrieve the message payload
        return message.ack(); // we excplicitly acknowledge the message
    }

    @Incoming("countries-in")
    public void otherConsumeCountry(ConsumerRecord<String, CountryDto> message) {
        /**
         * ConsumerRecord<K, V> containes a key/value pair to be received from Kafka. This also consists of a topic name and 
         * a partition number from which the record is being received, an offset that points 
         * to the record in a Kafka partition, and a timestamp as marked by the corresponding ProducerRecord.
         */

        logger.infov("New incoming message: {0}", message);
        logger.infov("Topic={0}, Partition={1}, Offset={2}, Headers={3}, Timestamp={4}", 
                        message.topic(), message.partition(), message.offset(), message.headers(), message.timestamp());
    }

    @Incoming("countries-in")
    public void lastConsumeCountry(Record<String, CountryDto> message) {
        // A Record<K, V> Represents a produced Kafka record, so a pair {key, value}.

        logger.infov("New incoming message key: {0}", message.key());  // we retrieve the message key
        logger.infov("New incoming message payload: {0}", message.value()); // we retrieve the message payload or value
    }
}
