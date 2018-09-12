package com.xmrbi.rinoWeb.controller;

import com.xmrbi.rinoWeb.domain.HighRptStation;
import com.xmrbi.rinoWeb.service.DailyInfoService;
import com.xmrbi.rinoWeb.vo.FeePassDaily;
import com.xmrbi.rinoWeb.vo.MonthFeeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
@RequestMapping("/dailyInfo")
@RestController
public class DailyInfoController {
    @Autowired
    DailyInfoService dailyInfoService;


    @RequestMapping(value = "feePasslist")
    @ResponseBody
    public Map<String,Object> feePasslist() {
        try {
            Map<String,Object> map = new HashMap<>();
            FeePassDaily xmdq=dailyInfoService.getFeePassDaily("0001",null);
            FeePassDaily xmdq_yd=dailyInfoService.getFeePassDaily("0001",new Date());
            map.put("xmdq",xmdq);
            map.put("xmdq_yd",xmdq_yd);
            FeePassDaily hcdq=dailyInfoService.getFeePassDaily("0002",null);
            FeePassDaily hcdq_yd=dailyInfoService.getFeePassDaily("0002",new Date());
            map.put("hcdq",hcdq);
            map.put("hcdq_yd",hcdq_yd);

            FeePassDaily jmdq=dailyInfoService.getFeePassDaily("0003",null);
            FeePassDaily jmdq_yd=dailyInfoService.getFeePassDaily("0003",new Date());
            map.put("jmdq",jmdq);
            map.put("jmdq_yd",jmdq_yd);

            FeePassDaily xldq=dailyInfoService.getFeePassDaily("0004",null);
            FeePassDaily xldq_yd=dailyInfoService.getFeePassDaily("0004",new Date());
            map.put("xldq",xldq);
            map.put("xldq_yd",xldq_yd);
            FeePassDaily xasd=dailyInfoService.getFeePassDaily("0005",null);
            FeePassDaily xasd_yd=dailyInfoService.getFeePassDaily("0005",new Date());
            map.put("xasd",xasd);
            map.put("xasd_yd",xasd_yd);

            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH )+1;
            cal.set(Calendar.MONTH,cal.get(Calendar.MONTH)-1);
            int lastmonth=cal.get(Calendar.MONTH)+1;

            //DateUtil.getLastDayOfMonth()
            MonthFeeVo monthFeeVo=dailyInfoService.getFeeMonth(year,month);
            MonthFeeVo monthFeeVo_lastmonth=dailyInfoService.getFeeMonth(year,lastmonth);
            map.put("monthFeeVo",monthFeeVo);
            map.put("monthFeeVo_lastmonth",monthFeeVo_lastmonth);

            return map;
        } catch (Exception e) {
            //logger.info("listSysPlaza查询出错" + e.getMessage());
            System.out.println("feePasslist查询出错" + e.getMessage());
            return null;
        }
    }
    @RequestMapping(value = "highRptlist")
    @ResponseBody
    public Map<String,Object> highRptlist() {
        try {
            Map<String,Object> map = new HashMap<>();
            HighRptStation xzzx=dailyInfoService.getHighRptStationInfo("3550");//厦漳主线
            HighRptStation xzzx_yd=dailyInfoService.getYesterDayHighRptStationInfo("3550");//厦漳主线
            map.put("xzzx",xzzx);
            map.put("xzzx_yd",xzzx_yd);
            HighRptStation xl=dailyInfoService.getHighRptStationInfo("3504");//杏林
            HighRptStation xl_yd=dailyInfoService.getYesterDayHighRptStationInfo("3504");//杏林
            map.put("xl",xl);
            map.put("xl_yd",xl_yd);

            HighRptStation hc=dailyInfoService.getHighRptStationInfo("3507");//海沧
            HighRptStation hc_yd=dailyInfoService.getYesterDayHighRptStationInfo("3507");//海沧
            map.put("hc",hc);
            map.put("hc_yd",hc_yd);

            HighRptStation xy=dailyInfoService.getHighRptStationInfo("3508");//新阳
            HighRptStation xy_yd=dailyInfoService.getYesterDayHighRptStationInfo("3508");//新阳
            map.put("xy",xy);
            map.put("xy_yd",xy_yd);

            HighRptStation xmx=dailyInfoService.getHighRptStationInfo("3509");//厦门西
            HighRptStation xmx_yd=dailyInfoService.getYesterDayHighRptStationInfo("3509");//厦门西
            map.put("xmx",xmx);
            map.put("xmx_yd",xmx_yd);



            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH )+1;
            cal.set(Calendar.MONTH,cal.get(Calendar.MONTH)-1);
            int lastmonth=cal.get(Calendar.MONTH)+1;

            //DateUtil.getLastDayOfMonth()
            MonthFeeVo highmonthFeeVo=dailyInfoService.getHighMonthfee(year,month);
            MonthFeeVo highmonthFeeVo_lastmonth=dailyInfoService.getHighMonthfee(year,lastmonth);
            map.put("highmonthFeeVo",highmonthFeeVo);
            map.put("highmonthFeeVo_lastmonth",highmonthFeeVo_lastmonth);
            //HighRptDailyInfoVo highRptDailyInfoVo=new HighRptDailyInfoVo(highRptStationList,highRptStationList_yd);
            return map;
        } catch (Exception e) {
            //logger.info("listSysPlaza查询出错" + e.getMessage());
            System.out.println("highRptlist查询出错" + e.getMessage());
            return null;
        }
    }

}
