package com.example.librarytest.service.impl;

import com.example.librarytest.ex.ServiceCode;
import com.example.librarytest.mapper.CouponMapper;
import com.example.librarytest.service.CouponService;
import com.example.librarytest.web.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponMapper couponMapper;

    /**
     * 给指定用户添加指定优惠卷(管理员功能)
     * @param couponid
     * @param userid
     * @return
     */
    @Override
    public JsonResult<String> addCouponToUser(Integer couponid, Long userid) {
        JsonResult<String> jsonResult = new JsonResult<>();
        if (couponMapper.giveCouponToUser(couponid,userid) > 0 ){
            jsonResult.setCode(ServiceCode.OK.toString());
            jsonResult.setMessage("成功");
            return jsonResult;
        }
        return jsonResult;
    }
}
