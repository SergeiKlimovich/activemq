package com.klimovich.activemq.virtualtopic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.klimovich.activemq.BasicPubSub.MessageConsumer;
import com.klimovich.activemq.model.SystemMessage;

@Component
public class VirtualMessageConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

    @JmsListener(destination = "Consumer.myConsumer1.VirtualTopic.MY-SUPER-TOPIC")
    public void messageListenerFromVirtualTopic(SystemMessage systemMessage) {
        LOGGER.info("Message received from Virtual topic. {}", systemMessage);
    }

    @JmsListener(destination = "Consumer.myConsumer2.VirtualTopic.MY-SUPER-TOPIC")
    public void messageListenerTwoFromVirtualTopic(SystemMessage systemMessage) {
        LOGGER.info("Message received from Virtual topic. {}", systemMessage);
    }
}
