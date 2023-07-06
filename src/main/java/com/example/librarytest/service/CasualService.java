package com.example.librarytest.service;


import com.example.librarytest.pojo.entity.CouponEntity;
import com.example.librarytest.web.JsonResult;

import java.util.List;
import java.util.Map;

public interface CasualService {


    Map<String, Object> buyBook(Integer bookId,Integer couponId);

    Map<String,Object> bookList();

    JsonResult<List<CouponEntity>> selectCoupon();

}
