package com.zyj.mq.rabbit;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import com.zyj.mq.rabbit.utils.RabbitMqUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 生产者
 */
public class Producer {
    // 队列名称
    public static  final  String QUEUE_NAME = "hello1";
    public static void main(String[] args){
        try {
            // 获取信道
            Channel channel = RabbitMqUtils.getChannel();
            /**
             * 生成一个队列
             * 1。 队列名称
             * 2。 队列里面的消息是否持久化（磁盘），默认情况消息存储在内存中
             * 3。 给队列是否只供一个消费者进行消费，是否进行消息共享，true可以由多个消费者
             * 4. 是否自动删除 最后一个消费者断开连接以后，该队列是否自动删除，true:自动删除
             * 5。 其他参数
             */
            channel.queueDeclare(QUEUE_NAME, false, false,  true,null );
            String msg = "hello world" ;
            /**
             * 发送一个参数
             * 1。发送到哪一个交换机
             * 2。路由的key 本次事队列名称
             * 3. 参数
             * 4. 发送的消息体
             */
            channel.basicPublish( "",  QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN,msg.getBytes());
            System.out.println("消息发送完毕");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
