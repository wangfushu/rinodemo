package com.xmrbi.rinoWeb.dao;

import com.xmrbi.rinoWeb.domain.FeeMTCFee;
import com.xmrbi.rinoWeb.domain.FeeMTCFeePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 *
 * @description :
 * ---------------------------------
 * @Author: wangfushu
 * @Date: 2018-09-11 9:14
 */
public interface FeeMTCFeeDao extends JpaRepository<FeeMTCFee, FeeMTCFeePK> {

    @Query(value = "select sum(TotalFee) from Fee_MTCFee where PlaNo=? and TollDate=? ",nativeQuery = true)
    public Double sumFeeMtcFee(String PlaNo,String tollDate);

}
