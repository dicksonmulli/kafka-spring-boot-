package io.tpd.kafkaexample.impl;

import io.tpd.kafkaexample.services.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProducerImpl implements Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "user";

    @Autowired
    private KafkaTemplate stringKafkaTemplate;

    @Override
    public void sendMessage(String message) {
        logger.info(String.format("#################################### -> Producing message -> %s", message));
        this.stringKafkaTemplate.send(TOPIC, message);
    }

}
