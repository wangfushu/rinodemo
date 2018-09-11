package com.xmrbi.rinoWeb.dao;

import com.xmrbi.rinoWeb.domain.FeePassCountHour;
import com.xmrbi.rinoWeb.domain.FeePassCountHourPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;


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
public interface FeePassCountHourDao extends JpaRepository<FeePassCountHour, FeePassCountHourPK> {
    FeePassCountHour findTopBy(String stationID);
    FeePassCountHour findTopByStationIDAAndTotalTimeOrderByUpDateTimeDesc(String stationID, Date totalTime);
}
