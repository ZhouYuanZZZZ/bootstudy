package com.zy.study.bootstudy.services;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

public class Consumer1 extends DefaultConsumer {

    private static final Logger logger = LoggerFactory.getLogger(Consumer1.class);

    public Consumer1(Channel channel) {
        super(channel);
    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String message = new String(body, "UTF-8");
        logger.info(" [x] Received '" + message + "'");

        //this.getChannel().basicAck(envelope.getDeliveryTag(), false);
    }
}
