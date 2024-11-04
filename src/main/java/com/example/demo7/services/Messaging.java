package com.example.demo7.services;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "inputChannel")
public interface Messaging {
    void writeDown(@Header(FileHeaders.FILENAME) String filename, String data);
}
