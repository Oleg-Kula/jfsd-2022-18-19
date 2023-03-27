package com.gmail.kulacholeg.jfsd20221819.message;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class DataReceivedMessage {

    private String recipientId;

    private String subject;

    private String content;

    private String email;
}
