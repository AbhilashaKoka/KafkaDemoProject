package com.example.SpringBootKafkaDemoProject.kafka;

import com.example.SpringBootKafkaDemoProject.payload.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {
    private static final Logger LOGGER= LoggerFactory.getLogger(JsonKafkaProducer.class);
    private KafkaTemplate<String, User> KafkaTemplate;


    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate){
        this.KafkaTemplate= kafkaTemplate;
    }

    public void sendMessage(User data){
        LOGGER.info(String.format("Message sent -> %s",data.toString()));
        Message<User> message= MessageBuilder.withPayload(data)
                .setHeader(KafkaHeaders.TOPIC,"java-topic-json")
                .build();
        KafkaTemplate.send(message);


    }
}
