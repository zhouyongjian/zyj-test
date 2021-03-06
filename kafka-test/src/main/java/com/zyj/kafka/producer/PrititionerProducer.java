package com.zyj.kafka.producer;

import com.zyj.kafka.partitioner.MyPartitioner;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.Future;

public class PrititionerProducer {
    public static void main(String[] args) {
        // 1、创建kafka生产者的配置信息
        Properties properties = new Properties();

        // 2、指定连接的kafka集群
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"");


        // 3、ack应答级别
        properties.put(ProducerConfig.ACKS_CONFIG,"all");

        // 4、重试次数
        properties.put("retries",3);

        // 5、批次大小16Kb
        properties.put("batch.size",16384);

        // 6、等待时间(和5 属于两种触发机制)
        properties.put("linger.ms","1");

        // 7、RecordAccumulator缓冲区大小，32Mb
        properties.put("buffer.memory",33554432);

        // 8、key,value序列化
        properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

        // 9、创建生产者对象
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);


        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG,"com.zyj.kafka.partitioner.MyPartitioner");
        // 10、发送数据
        for (int i = 0; i < 10; i++) {
            Future<RecordMetadata> first = producer.send(new ProducerRecord<String, String>("first", "zyj" + i));
            try{
                RecordMetadata recordMetadata = first.get();// 异步变同步，使用场景，保证消息有序性的时候设置一个partition并不能完全保证有序，这时候可以改为同步发送
            }catch (Exception e){
                e.printStackTrace();
            }


        }
        // 11、关闭资源
        producer.close();


    }
}
