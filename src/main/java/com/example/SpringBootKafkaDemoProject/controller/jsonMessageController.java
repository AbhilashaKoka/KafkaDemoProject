package com.example.SpringBootKafkaDemoProject.controller;
import com.example.SpringBootKafkaDemoProject.kafka.JsonKafkaProducer;
import com.example.SpringBootKafkaDemoProject.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class jsonMessageController {

    private JsonKafkaProducer jsonKafkaProducer;

    public jsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json Message Sent to Kafka Topic");

    }
}
