package com.penn.springactivemq.controller;

import com.penn.springactivemq.mq.ActivemqProducer;
import com.penn.spring.activemq.comm.po.PersonVo;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class MqController {

    final Logger logger = Logger.getLogger(MqController.class);

    @Autowired
    private ActivemqProducer activemqProducer;

    @Resource(name = "queueDestination")
    private ActiveMQQueue destination;

    @RequestMapping("/send")
    public String send() {
        activemqProducer.sendMessage( "----->hello ,this is a queue activemq message!");
        logger.info("发送queue消息：----->hello ,this is a queue activemq message!");
        return "index";
    }

    @RequestMapping("/sendObj")
    public String sendObj() {
        PersonVo po = new PersonVo();
        po.setPersonId(10000001l);
        po.setPersonName("administrator");
        activemqProducer.sendObjectMessage(po);
        logger.info("发送queue消息：----->hello ,this is a obj activemq message!");
        return "index";
    }

    @RequestMapping("/sendTopic")
    public String sendTopic() {
        activemqProducer.sendTopicMessage( "====>hello ,this is a topic activemq message!");
        logger.info("发送topic消息：----->hello ,this is a topic activemq message!");
        return "index";
    }

}
