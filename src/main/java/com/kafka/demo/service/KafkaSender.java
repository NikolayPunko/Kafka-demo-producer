package com.kafka.demo.service;

import com.kafka.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, User> userKafkaTemplate;

    public void sendMessage(String message, String topicName) {   //текст
        log.info("Sending : {}", message);
        log.info("--------------------------------");

        kafkaTemplate.send(topicName, message);
    }

    public void sendCustomMessage(User user, String topicName) {   //объект
        log.info("Sending Json Serializer : {}", user);
        log.info("--------------------------------");

        userKafkaTemplate.send(topicName, user);
    }


}
