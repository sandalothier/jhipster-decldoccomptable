package com.fisc.decldoccomptable.web.rest;

import com.fisc.decldoccomptable.service.DecldoccomptableKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/decldoccomptable-kafka")
public class DecldoccomptableKafkaResource {

    private final Logger log = LoggerFactory.getLogger(DecldoccomptableKafkaResource.class);

    private DecldoccomptableKafkaProducer kafkaProducer;

    public DecldoccomptableKafkaResource(DecldoccomptableKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
