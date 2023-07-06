package com.example.librarytest.mapper;

import com.example.librarytest.pojo.entity.CouponEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CouponMapper {
    /**
     * 查看该用户所有的优惠卷
     * @param userid
     * @return
     */
    List<CouponEntity> selectCouponEntity(@Param("userid") Long userid);

    /**
     * 查看指定优惠卷用户是否拥有
     * @param userid
     * @return
     */
    CouponEntity selectCouponById(Long userid,Integer couponId);


    /**
     * 当购买成功后削减对应优惠卷
     */
    Integer updateCouponNum(Long userid,Integer couponId);


    /**
     * 给指定用户添加优惠劵
     */
    Integer giveCouponToUser(Integer couponid,Long userid);
}
