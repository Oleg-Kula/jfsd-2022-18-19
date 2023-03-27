package com.gmail.kulacholeg.jfsd20221819.controller;

import com.gmail.kulacholeg.jfsd20221819.message.DataReceivedMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
public class DataController {

    @Value("${kafka.topic.dataReceived}")
    private String messageReceivedTopic;

    private final KafkaOperations<String, DataReceivedMessage> kafkaOperations;

    @PostMapping
    public void receiveData(@RequestBody DataReceivedMessage message){
        kafkaOperations.send(messageReceivedTopic, message.getRecipientId(), message);
    }

}
