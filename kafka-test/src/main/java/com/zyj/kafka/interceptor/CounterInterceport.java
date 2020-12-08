package com.zyj.kafka.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class CounterInterceport implements ProducerInterceptor<String, String> {
    private AtomicInteger success = new AtomicInteger();
    private AtomicInteger error = new AtomicInteger();
    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> record) {
        return record;
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
        if (metadata != null){
            success.incrementAndGet();
        }else {
            error.incrementAndGet();
        }
    }

    @Override
    public void close() {
        System.out.println("success : " + success);
        System.out.println("error : " + error);
    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
