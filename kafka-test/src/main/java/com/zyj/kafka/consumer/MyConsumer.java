package com.zyj.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class MyConsumer {
    public static void main(String[] args) {
        Properties properties = new Properties();

        //1.连接集群
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"");

        //2.开启自动提交
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,true);

        //3.自动提交的延时
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,"1000");

        //4.key,value反序列化
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");

        //5.设置消费者组
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "zyj");


        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, null);//换组或者，保存的offset的数据已经被删除或者过期了，才会生效，默认为latest
     String doc =  "What to do when there is no initial offset in Kafka or if the current " +
             "offset does not exist any more on the server (e.g. because that data has been deleted):" +
             " <ul><li>earliest: automatically reset the offset to the earliest offset<li>latest: " +
             "automatically reset the offset to the latest offset</li><li>none: throw exception " +
             "to the consumer if no previous offset is found for the consumer's group" +
             "</li><li>anything else: throw exception to the consumer.</li></ul>";


        //6.创建消费者
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);// 1、创建kafka生产者的配置信息

        //7.订阅主题
        consumer.subscribe(Arrays.asList("first","second")); //主题不存在不会抛异常

        while (true){
            //8.获取数据
            ConsumerRecords<String, String> consumerRecords = consumer.poll(100);

            //解析consumer
            for (ConsumerRecord<String, String> record : consumerRecords){
                System.out.println(record.key() + "---" + record.value());
            }
            consumer.commitSync();
        }

    }
}
