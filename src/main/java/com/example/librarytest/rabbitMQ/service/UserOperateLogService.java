package com.example.librarytest.rabbitMQ.service;


import com.example.librarytest.config.RabbitConfig;
import com.example.librarytest.pojo.entity.AopEntity;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserOperateLogService {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Transactional
    @RabbitListener(queues = RabbitConfig.STOCK_QUEUE_FIVE)
    @RabbitHandler
    public void userOperateLog(AopEntity aopEntity){
        //以下是处理entity的写法.--------------
        Map map = new HashMap();



















        Gson gson = new Gson();
        String message =  gson.toJson(map);
        kafkaTemplate.send("KafkaUserActionBehavior",message);
    }

}
