package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/8/14
 * @ Description：
 * @ throws
 */
@Controller
public class TopicSendMessage {

    @Autowired
    private JmsTemplate jmsTemplate;

    @RequestMapping("/send")
    @ResponseBody
    public String send(){
        jmsTemplate.send("topic", new MessageCreator() {
            @Override
            public Message createMessage(Session session)
                    throws JMSException {
                return  session.createTextMessage("topic+++++++++要发送的数据");
            }
        });
        return "success!";
    }


}
