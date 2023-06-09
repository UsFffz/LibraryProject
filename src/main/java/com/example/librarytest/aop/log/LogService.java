package com.example.librarytest.aop.log;


import com.example.librarytest.aop.anotation.UserLog;
import com.example.librarytest.pojo.entity.AopEntity;
import com.example.librarytest.util.LoginUtils;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

@Aspect
@Component
@Slf4j
public class LogService {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Pointcut("@annotation(com.example.librarytest.aop.anotation.UserLog)")
    private void log(){

    }

    @Around("log() && @annotation(userLog)")
    public Object userLog(ProceedingJoinPoint pjd, UserLog userLog) throws Throwable {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String remoteAddr = LoginUtils.getIpAddress(request);//如果是localhost访问会记录ipv6格式的本机地址,正常
        String userAgent=request.getHeader("User-Agent");
        AopEntity aopEntity = new AopEntity();
        aopEntity.setDate(getNowDateStr())
                 .setUserId(1017)
                 .setResult(3)
                 .setOperate(userLog.value())
                 .setRemoteAddr(remoteAddr)
                 .setUserAgent(userAgent);
        mongoTemplate.save(aopEntity,"userlog");
        Map<String,Object> map = (Map<String, Object>) pjd.proceed();
        Gson gson = new Gson();
        String kafkaMap =  gson.toJson(aopEntity);
        kafkaTemplate.send("KafKaUserLog",kafkaMap);
        return map;
    }


    /**
     * 获取当前时间
     * @return
     */
    private String getNowDateStr(){
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simple.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        String nowdate = simple.format(new Date());
        nowdate = nowdate.substring(0,14) + "00:00" ;
        return nowdate;
    }
}
