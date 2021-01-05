package com.zyj.es;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;

public class EmployeeCRUD {
    public static void main(String[] args) throws Exception{
        Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();

        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getLocalHost(),9300));

create(client);
        client.close();
    }


    public static void  create(TransportClient client) throws Exception{
        IndexResponse indexResponse = client.prepareIndex("company", "employee", "1").setSource(XContentFactory.jsonBuilder().startObject()
                .field("name", "zyj")
                .field("age", 28)
                .field("salary", 2000)
                .field("position", "staff").endObject())
                .get();
        System.out.println(indexResponse.getResult());

    }
}
