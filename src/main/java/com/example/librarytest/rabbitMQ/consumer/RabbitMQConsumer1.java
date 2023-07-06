package com.example.librarytest.rabbitMQ.consumer;


import com.example.librarytest.config.RabbitConfig;
import com.example.librarytest.mapper.TestPlayMapper;
import com.example.librarytest.pojo.entity.BookTestRabbit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Slf4j
public class RabbitMQConsumer1 {

    @Autowired
    private TestPlayMapper testPlayMapper;


    @RabbitHandler
    @Transactional
    @RabbitListener(queues = RabbitConfig.STOCK_QUEUE)
    public void JieShou(BookTestRabbit bookTestRabbit){
        System.out.println("警告,已经开始添加图书");
        testPlayMapper.insertBook(bookTestRabbit);
        System.out.println("添加成功");
    }
}
