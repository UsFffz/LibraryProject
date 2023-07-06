package com.example.librarytest.rabbitMQ.consumer;


import com.example.librarytest.codenum.WarnEnum;
import com.example.librarytest.codenum.WarnMessage;
import com.example.librarytest.config.RabbitConfig;
import com.example.librarytest.mapper.TestPlayMapper;
import com.example.librarytest.pojo.entity.BookTestRabbit;
import com.example.librarytest.pojo.entity.KafKaWarn;
import com.example.librarytest.util.BookBuySuccess;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class RabbitMQConsumer2 {

    @Autowired
    private TestPlayMapper testPlayMapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private BookBuySuccess bookBuySuccess;

    @RabbitHandler
    @Transactional
    @RabbitListener(queues = RabbitConfig.STOCK_QUEUE_TWO)
    public void buyBook(Integer bookId) {
        System.out.println("============开始全自动购买=================");
        Integer liang = testPlayMapper.buyBook(bookId);
        BookTestRabbit bookTestRabbit = testPlayMapper.selectBookById(bookId);
        if (liang <= 0) {
            KafKaWarn kafKaWarn = new KafKaWarn();
            kafKaWarn.setBookId(bookId)
                    .setWarnCode(WarnEnum.ERRORBUY_CODE.getNum())
                    .setWarnMessage(WarnMessage.WARN_MESSAGE_ERROR)
                    .setInventory(bookTestRabbit.getInventory())
                    .setBookName(bookTestRabbit.getName());
            String mongoName = "niuBi";
            System.out.println("准备发送到mongo中进行记录");
            mongoTemplate.save(kafKaWarn,mongoName);
            return;
        } else {
            System.out.println("准备发送到kafka录入成功日志");
            bookBuySuccess.userSuccessLog(bookId, bookTestRabbit.getName(), bookTestRabbit.getInventory());
        }
    }
}
