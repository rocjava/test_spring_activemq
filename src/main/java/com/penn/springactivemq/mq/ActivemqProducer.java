package com.penn.springactivemq.mq;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component(value = "activemqProducer")
public class ActivemqProducer {
    @Resource(name="queueJmsTemplate")
    private JmsTemplate queueJmsTemplate;

    @Resource(name="topicJmsTemplate")
    private JmsTemplate topicJmsTemplate;

    public void sendMessage(final String message) {
        queueJmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }

    public void sendTopicMessage(final String message){
        topicJmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }
}
