package com.example.librarytest.service.impl;

import com.example.librarytest.mapper.IntegralMapper;
import com.example.librarytest.service.IntegralService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class IntegralServiceImpl implements IntegralService {

    @Autowired
    private IntegralMapper integralMapper;


    /**
     * 给指定用户添加图书购买积分
     * @param userid
     * @param integral
     */
    @Override
    @Transactional
    @Async("normalThreadPool")
    public void addIntegralForUser(Long userid,Integer integral) {
        integralMapper.userAddIntegral(userid,integral);
    }

}
