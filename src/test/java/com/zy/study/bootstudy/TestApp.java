package com.zy.study.bootstudy;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.zy.study.bootstudy.services.Consumer1;
import com.zy.study.bootstudy.services.Consumer2;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class TestApp {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.1.142");
        factory.setUsername("zy");
        factory.setPassword("zy");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare("Q2", true, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        channel.basicConsume("Q5", false, new Consumer1(channel));
        channel.basicConsume("Q6", false, new Consumer2(channel));

    }
}
