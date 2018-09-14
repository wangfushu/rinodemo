package com.xmrbi.rinoWeb;

import com.xmrbi.rinoWeb.service.DailyInfoService;
import com.xmrbi.rinoWeb.vo.FeePassDaily;
import com.xmrbi.rinoWeb.vo.MonthFeeVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	DailyInfoService dailyInfoService;

	@Test
	public void contextLoads() {
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
		System.out.println("结束");

	}

}
