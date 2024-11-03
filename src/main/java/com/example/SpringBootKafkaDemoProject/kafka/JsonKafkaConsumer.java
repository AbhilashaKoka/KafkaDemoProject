package com.example.SpringBootKafkaDemoProject.kafka;

import com.example.SpringBootKafkaDemoProject.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER= LoggerFactory.getLogger(JsonKafkaConsumer.class);

   @KafkaListener(topics = "java-topic-json",groupId = "test-group")
   public void consume(User user){
LOGGER.info(String.format("Json Message received -> %s",user.toString()));

}
}