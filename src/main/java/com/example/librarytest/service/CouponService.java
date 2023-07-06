package com.example.librarytest.service;


import com.example.librarytest.web.JsonResult;

public interface CouponService {
    /**
     * 给指定用户添加优惠卷(管理员功能)
     * @return
     */
    JsonResult<String> addCouponToUser(Integer couponid,Long userid);
}
