package com.example.librarytest.kafka;


import com.example.librarytest.pojo.entity.AopEntity;
import com.google.gson.Gson;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class KafkaSuccessLog {

    @Autowired
    private MongoTemplate mongoTemplate;

    @KafkaListener(topics = "KafKaUserLog")
    @Async
    public void kafkaSuccess(ConsumerRecord<String,String> record){
        System.out.println("kafka已经接受到用户操作日志消息");
        String value = record.value();
        Gson gson = new Gson();
        AopEntity kafkaSuccess = gson.fromJson(value,AopEntity.class);
        System.out.println("接受的消息为:" + kafkaSuccess.toString());
        mongoTemplate.save(kafkaSuccess,"successlog");
        System.out.println("准备发送到mongo中准备录入到mongo");
    }
}
