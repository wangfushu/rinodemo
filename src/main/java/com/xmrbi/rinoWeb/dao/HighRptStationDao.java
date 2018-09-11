package com.xmrbi.rinoWeb.dao;

import com.xmrbi.rinoWeb.domain.HighRptStation;
import com.xmrbi.rinoWeb.domain.HighRptStationPK;
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
public interface HighRptStationDao extends JpaRepository<HighRptStation, HighRptStationPK> {
    HighRptStation findTopByStationIDOrderByUpDateTimeDesc(String stationID);
    HighRptStation findTopByStationIDAndTotalTimeOrderByUpDateTimeDesc(String stationID, Date totalTime);
}
