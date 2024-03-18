package com.kafka.demo.controller;

import com.kafka.demo.model.User;
import com.kafka.demo.service.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {


    private final KafkaSender kafkaSender;

    public KafkaController(KafkaSender kafkaSender) {
        this.kafkaSender = kafkaSender;
    }

    @PostMapping("/send-topic-1")
    public String send(@RequestBody String str){
        kafkaSender.sendMessage(str, "topic-1");
        return "OK";
    }

    @PostMapping("/send-topic-2")
    public String send2(@RequestBody String str){
        kafkaSender.sendMessage(str, "topic-2");
        return "OK";
    }

    @PostMapping("/send-topic-3")
    public String send3(@RequestBody String username){
        kafkaSender.sendCustomMessage(new User(username,35), "topic-3");
        return "OK";
    }
}
