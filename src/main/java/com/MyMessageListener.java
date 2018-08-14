package com;

import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/8/14
 * @ Description：
 * @ throws
 */
public class MyMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        ActiveMQTextMessage amessage = (ActiveMQTextMessage) message;
        try {

            // 从mq里面监听到消息并取出（*）
            String topic = amessage.getText();
            System.out.println("消息:" + topic);

        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
