package com.xmrbi.rinoWeb.service;

import com.xmrbi.rinoWeb.dao.FeePassCountDao;
import com.xmrbi.rinoWeb.dao.HighRptStationDao;
import com.xmrbi.rinoWeb.domain.HighRptStation;
import com.xmrbi.rinoWeb.utils.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
 * @Date: 2018-09-10 16:05
 */
@Service
public class DailyInfoService {

    @Resource
    FeePassCountDao feePassCountDao;
    @Resource
    HighRptStationDao highRptStationDao;

    public HighRptStation getHighRptStationInfo(String stationID){
        return highRptStationDao.findTopByStationIDOrderByUpDateTimeDesc(stationID);
    }
    public HighRptStation getYesterDayHighRptStationInfo(String stationID){
        Date totalTime = DateUtil.getYesterDayTime(new Date());
        return highRptStationDao.findTopByStationIDAndTotalTimeOrderByUpDateTimeDesc(stationID,totalTime);
    }

}
