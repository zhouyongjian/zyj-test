package com.zyj.mq.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import com.zyj.mq.rabbit.utils.RabbitMqUtils;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class Task {
    public static  final  String QUEUE_NAME = "ack_hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtils.getChannel();
        // 开启发布确认
        channel.confirmSelect();
        // 持久化到磁盘
        boolean durble = true;
        channel.queueDeclare(QUEUE_NAME, durble, false, false, null);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String message = scanner.nextLine();
            channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes("UTF-8"));
            System.out.println("生产者发送消息：" + message);
        }
    }


}
