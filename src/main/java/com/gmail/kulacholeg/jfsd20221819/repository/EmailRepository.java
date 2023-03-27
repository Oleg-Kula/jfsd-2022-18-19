package com.gmail.kulacholeg.jfsd20221819.repository;

import com.gmail.kulacholeg.jfsd20221819.data.EmailData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmailRepository extends MongoRepository<EmailData, String> {

    List<EmailData> getEmailDataByIsSend(boolean isSend);
}
