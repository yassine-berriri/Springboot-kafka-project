package net.javaguides.springboot_kafka_tutorial.controller;

import net.javaguides.springboot_kafka_tutorial.kafka.jsonKafkaProducer;
import net.javaguides.springboot_kafka_tutorial.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {
    private jsonKafkaProducer kafkaProducer;

    public JsonMessageController(jsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok(String.format("json Message sent to kafka topic"));
    }
}
