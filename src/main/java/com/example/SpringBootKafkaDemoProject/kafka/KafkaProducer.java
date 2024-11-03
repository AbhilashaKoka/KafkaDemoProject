package com.example.SpringBootKafkaDemoProject.kafka;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
public class KafkaProducer {

    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaProducer.class);
    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    //Message sent to the testTopic
    public void sendMessage(String message) {
        LOGGER.info(String.format("Message sent %s", message));
        kafkaTemplate.send("testTopic", message);
    }

}