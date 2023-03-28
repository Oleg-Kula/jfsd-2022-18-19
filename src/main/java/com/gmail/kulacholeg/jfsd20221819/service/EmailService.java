package com.gmail.kulacholeg.jfsd20221819.service;

import com.gmail.kulacholeg.jfsd20221819.data.EmailData;
import com.gmail.kulacholeg.jfsd20221819.message.DataReceivedMessage;
import com.gmail.kulacholeg.jfsd20221819.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailRepository repository;
    private final JavaMailSender emailSender;

    private static EmailData messageToData(DataReceivedMessage message){
        EmailData data = new EmailData();
        data.setEmail(message.getEmail());
        data.setSubject(message.getSubject());
        data.setContent(message.getContent());
        data.setRecipientId(message.getRecipientId());
        data.setIsSend(false);

        return data;
    }

    private EmailData send(EmailData data){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("se492367@gmail.com");
        message.setTo(data.getEmail());
        message.setSubject(data.getSubject());
        message.setText(data.getContent());
        try{
            emailSender.send(message);
            data.setIsSend(true);
            data.setErrorMessage("");
        }catch (Exception e){
            data.setErrorMessage(e.getMessage());
        }
        return data;
    }
    public void processDataReceived(DataReceivedMessage message) {
        EmailData email = messageToData(message);
        repository.save(this.send(email));
    }

    @Scheduled(fixedRate = 300000)
    private void retrySend(){
        List<EmailData> emails = repository.getEmailDataByIsSend(false);

        if (!emails.isEmpty()){
            for(EmailData email : emails){
                repository.save(this.send(email));
            }
        }
    }


}
