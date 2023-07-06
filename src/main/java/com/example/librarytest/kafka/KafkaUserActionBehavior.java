package com.example.librarytest.kafka;

import com.google.gson.Gson;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class KafkaUserActionBehavior {

    @Autowired
    private MongoTemplate mongoTemplate;

    @KafkaListener(topics = "KafkaUserActionBehavior")
    public void kafkaUserActionBehavior(ConsumerRecord<String,String> record){
        System.out.println("kafka已接收到用户操作记录");
        String value = record.value();
        Gson gson = new Gson();
        Map<String,Object> map = gson.fromJson(value,Map.class);
        mongoTemplate.save(map,"fuck");
        System.out.println("用户操作信息已录入成功");
    }
}
