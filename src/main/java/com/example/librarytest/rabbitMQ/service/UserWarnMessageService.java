package com.example.librarytest.rabbitMQ.service;

import com.example.librarytest.config.RabbitConfig;
import com.example.librarytest.pojo.entity.KafKaWarn;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserWarnMessageService {
    @Autowired
    private MongoTemplate mongoTemplate;




    @Transactional
    @RabbitListener(queues = RabbitConfig.STOCK_QUEUE_FOUR)
    @RabbitHandler
    public void userWarnMessageToMongo(KafKaWarn kafKaWarn){
        System.out.println("准备将警报信息储存进mongodb中");
        String mongoName = "userBuyfail";
        mongoTemplate.save(kafKaWarn,mongoName);
        System.out.println("已将警报信息成功放入mongo中");
    }
}
