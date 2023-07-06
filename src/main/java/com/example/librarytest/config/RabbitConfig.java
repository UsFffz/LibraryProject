package com.example.librarytest.config;


import org.apache.hadoop.yarn.webapp.hamlet2.Hamlet;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 将rabbitMq交由spring管理
 */
@Configuration
public class RabbitConfig {
    //交换机1
    public static final String STOCK_EX = "stock_ex";

    //路由Key1
    public static final String STOCK_ROUT = "stock_rout";

    //队列1
    public static final String STOCK_QUEUE="stock_queue";

    //交换机2
    public static final String STOCK_EX_TWO = "stock_ex_two";

    //路由Key2
    public static final String STOCK_ROUT_TWO  = "stock_rout_two";

    //队列2
    public static final String STOCK_QUEUE_TWO = "stock_queue_two";

    //路由Key3
    public static final String STOCK_ROUT_THREE = "stock_rout_three";

    //队列3
    public static final String STOCK_QUEUE_THREE = "stock_queue_three";

    //路由Key4
    public static final String STOCK_ROUT_FOUR = "stock_rout_four";

    //队列4
    public static final String STOCK_QUEUE_FOUR = "stock_queue_four";

    //路由Key5
    public static final String STOCK_ROUT_FIVE = "stock_rout_five";

    //队列5
    public static final String STOCK_QUEUE_FIVE = "stock_queue_five";


    /**
     * 交换机1
     * @return
     */
    @Bean
    public DirectExchange stockDirectExchange(){
        return new DirectExchange(STOCK_EX);
    }

    /**
     * 队列1
     * @return
     */
    @Bean
    public Queue stockQueue(){
        return new Queue(STOCK_QUEUE);
    }


    /**
     * 交换机2
     * @return
     */
    @Bean
    public DirectExchange stockDirectExchangeTwo(){
        return new DirectExchange(STOCK_EX_TWO);
    }

    /**
     * 队列2
     * @return
     */
    @Bean
    public Queue stockQueueTwo(){
        return new Queue(STOCK_QUEUE_TWO);
    }

    /**
     * 队列3
     */
    @Bean
    public Queue stockQueueThree(){
        return new Queue(STOCK_QUEUE_THREE);
    }

    /**
     * 队列4
     * @return
     */
    @Bean
    public Queue stockQueueFour(){
        return new Queue(STOCK_QUEUE_FOUR);
    }

    /**
     * 队列5
     */
    @Bean
    public Queue stockQueueFive(){
        return new Queue(STOCK_QUEUE_FIVE);
    }


    /**
     * 队列绑定1
     * @return
     */
    @Bean
    public Binding stockBinding(){
        return BindingBuilder.bind(stockQueue()).to(stockDirectExchange()).with(STOCK_ROUT);
    }

    /**
     * 队列绑定2
     * @return
     */
    @Bean
    public Binding stockBindingTwo(){
        return BindingBuilder.bind(stockQueueTwo()).to(stockDirectExchangeTwo()).with(STOCK_ROUT_TWO);
    }

    /**
     * 队列绑定3(使用一号交换机,不在新建)
     */
    @Bean
    public Binding stockBindingThree(){
        return BindingBuilder.bind(stockQueueThree()).to(stockDirectExchange()).with(STOCK_ROUT_THREE);
    }

    /**
     * 队列绑定4(使用二号交换机,不再新建)
     * @return
     */
    @Bean
    public Binding stockBindingFour(){
        return BindingBuilder.bind(stockQueueFour()).to(stockDirectExchangeTwo()).with(STOCK_ROUT_FOUR);
    }

    /**
     * 队列绑定5(使用一号交换机,不再新建)
     */
    @Bean
    public Binding stockBindingFive(){
        return BindingBuilder.bind(stockQueueFive()).to(stockDirectExchange()).with(STOCK_ROUT_FIVE);
    }


}
