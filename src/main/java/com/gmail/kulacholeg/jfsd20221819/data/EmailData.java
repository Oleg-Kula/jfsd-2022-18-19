package com.gmail.kulacholeg.jfsd20221819.data;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@FieldNameConstants
@Document("emails")
public class EmailData {

    @Id
    private String id;

    private String subject;

    private String content;

    private String email;

    private String recipientId;

    private Boolean isSend;
}
