package com.zyj.kafka.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

public class TimeInterceptor implements ProducerInterceptor<String, String> {
    public ProducerRecord onSend(ProducerRecord record) {
        Object value = record.value();

         return new ProducerRecord<>(record.topic(), record.partition(),
                record.key(),System.currentTimeMillis() + "," +  value);


    }

    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {

    }

    public void close() {

    }

    public void configure(Map<String, ?> configs) {

    }
}
