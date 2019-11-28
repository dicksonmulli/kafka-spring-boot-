package io.tpd.kafkaexample.impl;

import io.tpd.kafkaexample.services.Consumer;
import io.tpd.kafkaexample.services.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ConsumerImpl implements Consumer {
    private final Logger logger = LoggerFactory.getLogger(Producer.class);

    @KafkaListener(topics = "user")
    public void consume(String message) throws IOException {
        logger.info(String.format("################################################ -> Consumed message -> %s", message));
    }
}
