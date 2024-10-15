package net.javaguides.springboot_kafka_tutorial.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class messageKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(messageKafkaConsumer.class);
    @KafkaListener(topics = "javaguides", groupId = "myGroup")
    public void consume(String message) {
        LOGGER.info(String.format("Message recieved -> %s", message));

    }
}
