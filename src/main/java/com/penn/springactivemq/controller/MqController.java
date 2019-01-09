package com.penn.springactivemq.controller;

import com.penn.springactivemq.mq.ActivemqProducer;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class MqController {

    @Autowired
    private ActivemqProducer activemqProducer;

    @Resource(name = "queueDestination")
    private ActiveMQQueue destination;

    @RequestMapping("/send")
    public String index() {
        activemqProducer.sendMessage( "hello ,this is the first activemq message!");
        return "index";
    }

}
