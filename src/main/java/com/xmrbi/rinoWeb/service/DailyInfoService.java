package com.xmrbi.rinoWeb.service;

import com.xmrbi.rinoWeb.dao.FeePassCountHourDao;
import com.xmrbi.rinoWeb.dao.HighRptStationDao;
import com.xmrbi.rinoWeb.domain.HighRptStation;
import com.xmrbi.rinoWeb.utils.DateUtil;
import com.xmrbi.rinoWeb.vo.FeePassDaily;
import com.xmrbi.rinoWeb.vo.MonthFeeVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

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
 * @description :
 * ---------------------------------
 * @Author: wangfushu
 * @Date: 2018-09-10 16:05
 */
@Service
public class DailyInfoService {

    @Resource
    FeePassCountHourDao feePassCountHourDao;
    @Resource
    HighRptStationDao highRptStationDao;

    @PersistenceUnit
    private EntityManagerFactory emf;

    public HighRptStation getHighRptStationInfo(String stationID) {
        return highRptStationDao.findTopByStationIDOrderByUpDateTimeDesc(stationID);
    }

    public HighRptStation getYesterDayHighRptStationInfo(String stationID) {
        Date totalTime = DateUtil.getYesterDayTime(new Date());
        return highRptStationDao.findTopByStationIDAndTotalTimeOrderByUpDateTimeDesc(stationID, totalTime);
    }

/*    public FeePassCountHour getInFeePassCountHourInfo(String plaNo,String direction){
        return feePassCountHourDao.findTopByPlaNoAndAndDirectionOrderByUpDateTimeDesc(plaNo,direction);
    }
    public FeePassCountHour getOutFeePassCountHourInfo(String plaNo,String direction){
        Date totalTime = DateUtil.getYesterDayTime(new Date());
        return feePassCountHourDao.findTopByPlaNoAndDirectionAndTotalTimeOrderByUpDateTimeDesc(plaNo,direction,totalTime);
    }*/

    public FeePassDaily getFeePassDaily(String plaNo, Date totalTime) {
        EntityManager em = emf.createEntityManager();
        String sql = "select top 1 PlaNo,PlaName,TotalTime, " +
                "PassCounts as inpassCounts," +
                "(select top 1 b.PassCounts FROM Fee_PassCountHour b where b.Direction=1 and b.PlaNo=a.PlaNo and b.TotalTime=a.TotalTime order by b.UpDateTime desc) as outpassCounts," +
                "(select sum(TotalFee) from Fee_MTCFee c where PlaNo=a.PlaNo and TollDate=a.TotalTime ) as etcFee " +
                "FROM Fee_PassCountHour a where a.Direction=0 and a.PlaNo=" + plaNo + " ";
        if (null != totalTime) {
            String date = DateUtil.formatDate(DateUtil.getYesterDayTime(new Date()), "yyyy-MM-dd HH:mm:ss");
            sql += " and TotalTime= '" + date+"'";
        }
        sql += " order by a.UpDateTime desc";
        Query query = em.createNativeQuery(sql);
        //执行查询，返回的是对象数组(Object[])列表,
        //每一个对象数组存的是相应的实体属性
        List<Object[]> objectList = query.getResultList();
        FeePassDaily feePassDaily = new FeePassDaily();
        for (Object[] obj : objectList) {
            if (null != obj[0])
                feePassDaily.setPlaNo(String.valueOf(obj[0]));
            if (null != obj[1])
                feePassDaily.setPlaName(String.valueOf(obj[1]));
            if (null != obj[2])
                feePassDaily.setTotalTime(String.valueOf(obj[2]));
            if (null != obj[3])
                feePassDaily.setInPassCounts(Integer.valueOf(String.valueOf(obj[3])));
            if (null != obj[4])
                feePassDaily.setOutPassCounts(Integer.valueOf(String.valueOf(obj[4])));
            if (null != obj[5])
                feePassDaily.setMtcFee(Double.valueOf(String.valueOf(obj[5])));
        }
        em.close();
        return feePassDaily;
    }

    public MonthFeeVo getFeeMonth(int year ,int month) {
        EntityManager em = emf.createEntityManager();
        String sql = "select SUM(MTCFee) as mtc ,SUM(ETCFee) as etc from High_FeeMonth where FYear="+year+" and FMonth="+month+" and TotalTime='(select MAX(TotalTime) from High_FeeMonth where FYear="+year+" and FMonth="+month+")' ";
        Query query = em.createNativeQuery(sql);
        //执行查询，返回的是对象数组(Object[])列表,
        //每一个对象数组存的是相应的实体属性
        List<Object[]> objectList = query.getResultList();
        MonthFeeVo monthFeeVo = new MonthFeeVo();
        for (Object[] obj : objectList) {
            if (null != obj[0])
                monthFeeVo.setMtcfee(Double.valueOf(String.valueOf(obj[0])));
            if (null != obj[1])
                monthFeeVo.setEtcfee(Double.valueOf(String.valueOf(obj[1])));

        }
        em.close();
        return monthFeeVo;
    }

    public MonthFeeVo getHighMonthfee(int year ,int month) {
        EntityManager em = emf.createEntityManager();
        String sql = "select SUM(MTCFee) as mtc,(select SUM(YearFee) from Fee_YearMonth b where b.FYear=a.FYear and b.FMonth=a.FMonth )as etc from Fee_MTCMonth a where FYear="+year+" and FMonth="+month+" group by a.FYear,a.FMonth ";
        Query query = em.createNativeQuery(sql);
        //执行查询，返回的是对象数组(Object[])列表,
        //每一个对象数组存的是相应的实体属性
        List<Object[]> objectList = query.getResultList();
        MonthFeeVo monthFeeVo = new MonthFeeVo();
        for (Object[] obj : objectList) {
            if (null != obj[0])
                monthFeeVo.setMtcfee(Double.valueOf(String.valueOf(obj[0])));
            if (null != obj[1])
                monthFeeVo.setEtcfee(Double.valueOf(String.valueOf(obj[1])));

        }
        em.close();
        return monthFeeVo;
    }

}
