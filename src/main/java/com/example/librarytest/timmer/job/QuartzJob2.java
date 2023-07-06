package com.example.librarytest.timmer.job;


import com.example.librarytest.codenum.WarnEnum;
import com.example.librarytest.codenum.WarnMessage;
import com.example.librarytest.config.RabbitConfig;
import com.example.librarytest.mapper.TestPlayMapper;
import com.example.librarytest.pojo.entity.BookTestRabbit;
import com.example.librarytest.pojo.entity.KafKaWarn;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Slf4j
public class QuartzJob2 implements Job {

    @Autowired
    private TestPlayMapper testPlayMapper;


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    @Transactional
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        List<BookTestRabbit> bookList = testPlayMapper.selectAllBook();
        List<Integer> bookIdList = new ArrayList<>();
        for (BookTestRabbit bookTestRabbit : bookList) {
            Integer inventory = bookTestRabbit.getInventory();
            Integer bookId = bookTestRabbit.getBookId();
            if (inventory <= 5 && inventory > 0){
                System.out.println("该书库存不足");
                KafKaWarn kafKaWarn = new KafKaWarn();
                kafKaWarn.setWarnCode(WarnEnum.INSUFFICIENT_CODE.getNum())
                         .setWarnMessage(WarnMessage.WARN_MESSAGE_INVENTORY)
                         .setBookName(bookTestRabbit.getName())
                         .setInventory(bookTestRabbit.getInventory())
                         .setBookId(bookId);
                rabbitTemplate.convertSendAndReceive(RabbitConfig.STOCK_EX_TWO,RabbitConfig.STOCK_ROUT_FOUR,kafKaWarn);
                bookIdList.add(bookId);
            }else if (inventory <= 0){
                System.out.println("该书已告罄");
                KafKaWarn kafKaWarn = new KafKaWarn();
                kafKaWarn.setBookId(bookId)
                         .setWarnCode(WarnEnum.ERROR_CODE.getNum())
                         .setBookName(bookTestRabbit.getName())
                         .setInventory(0)
                         .setWarnMessage(WarnMessage.WARN_MESSAGE_INSUFFICIENT);
                Gson gson = new Gson();
//                String message = gson.toJson(kafKaWarn);
//                kafkaTemplate.send("kafkawarn",message);
                throw new NullPointerException();
            }else {
                bookIdList.add(bookId);
            }
        }
        Integer size = bookIdList.size() - 1;
        Integer randomIndex = new Random().nextInt(size);
        Integer useBookId = bookIdList.get(randomIndex);
        Integer inventory = testPlayMapper.selectInventory(useBookId);
        if (inventory > 0){
            System.out.println("已经准备发送到rabbit中");
            rabbitTemplate.convertSendAndReceive(RabbitConfig.STOCK_EX_TWO,RabbitConfig.STOCK_ROUT_TWO,useBookId);
        }
    }
}
