package com.klimovich.activemq.virtualtopic;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.klimovich.activemq.model.SystemMessage;

@RestController
public class VirtualPublisherController {

    @Autowired
    private JmsTemplate jmsTemplate;
    @PostMapping("/publishMessageInVirtualTopic")
    public ResponseEntity<String> publishMessageInVirtualTopic(@RequestBody SystemMessage systemMessage) {
        try {
            jmsTemplate.convertAndSend(new ActiveMQTopic("VirtualTopic.MY-SUPER-TOPIC"), systemMessage);
            return new ResponseEntity<>("Sent in Virtual Topic", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
