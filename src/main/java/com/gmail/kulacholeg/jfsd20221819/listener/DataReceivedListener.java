package com.gmail.kulacholeg.jfsd20221819.listener;

import com.gmail.kulacholeg.jfsd20221819.message.DataReceivedMessage;
import com.gmail.kulacholeg.jfsd20221819.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataReceivedListener {

    private final EmailService service;

    @KafkaListener(topics = "${kafka.topic.dataReceived}")
    public void dataReceived(DataReceivedMessage message){
        service.processDataReceived(message);
    }
}
