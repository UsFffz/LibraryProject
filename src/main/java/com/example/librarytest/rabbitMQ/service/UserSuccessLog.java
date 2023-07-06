package com.example.librarytest.rabbitMQ.service;


import com.example.librarytest.config.RabbitConfig;
import com.example.librarytest.pojo.entity.AopEntity;
import com.example.librarytest.pojo.entity.KafkaSuccess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class UserSuccessLog {

    @Autowired
    private MongoTemplate mongoTemplate;


    @RabbitHandler
    @Transactional
    @RabbitListener(queues = RabbitConfig.STOCK_ROUT_THREE)
    public void successLogService(KafkaSuccess kafkaSuccess){
        System.out.println("rabbitMQ已成功接受到日志,准备发往mongodb");
        mongoTemplate.save(kafkaSuccess,"successlog");
        System.out.println("准备发送到mongo中准备录入到mongo");
    }
}
