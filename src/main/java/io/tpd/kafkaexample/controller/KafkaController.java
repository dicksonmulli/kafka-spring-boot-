package io.tpd.kafkaexample.controller;

import io.tpd.kafkaexample.services.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class KafkaController {

    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public String  sendMessageToKafkaTopic(@RequestParam("message") String message) {
        this.producer.sendMessage(message);
        return "Published successfully";
    }
}
