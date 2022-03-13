package com.zyj.mq.rabbit;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.zyj.mq.rabbit.utils.RabbitMqUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Worker {
    public static  final  String QUEUE_NAME = "ack_hello";
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtils.getChannel();
        // 声明接受消息回调
        DeliverCallback deliverCallback =  (consumerTag, message) ->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(new String(message.getBody(),"UTF-8"));
            /**
             * 1。   消息标记的tag,
             * 2.    是否批量应答，false，不批量应答信道重的消息
             */
            channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
        };
        // 取消消息时的回调
        CancelCallback cancelCallback = (consumerTag) -> {
            System.out.println("消息消费被中断");
        };

        //大于1，不公平分发，也是欲取值
        channel.basicQos(5);
        /**
         * 消费者消费消息
         * 1。消费哪个队列
         * 2。消费成功后是否要自动应答，true代表自动应答 false代表手动应答
         * 3。消费者未成功消费的回调
         * 4。消费者取消消费的回调
         *
         */
        channel.basicConsume(QUEUE_NAME, false, deliverCallback, cancelCallback);
    }

}
