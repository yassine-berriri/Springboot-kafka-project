package net.javaguides.springboot_kafka_tutorial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import net.javaguides.springboot_kafka_tutorial.kafka.messageKafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {
 private messageKafkaProducer kafkaProducer;



    public MessageController(messageKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    // http://localhost:8080/api/v1/kafka/publish?message=hello world
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok(String.format("Message sent: %s", message));
    }


}
