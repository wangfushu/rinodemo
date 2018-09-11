package com.xmrbi.rinoWeb.vo;

import com.xmrbi.rinoWeb.domain.FeePassCountHour;

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
 *
 * @description :
 * ---------------------------------
 * @Author: wangfushu
 * @Date: 2018-09-11 10:24
 */
public class FeePassDailyInfoVo {
    public List<FeePassCountHour> todayPassCount;
    public List<FeePassCountHour> yesterdayPassCount;

    public List<FeePassCountHour> getTodayPassCount() {
        return todayPassCount;
    }

    public void setTodayPassCount(List<FeePassCountHour> todayPassCount) {
        this.todayPassCount = todayPassCount;
    }

    public List<FeePassCountHour> getYesterdayPassCount() {
        return yesterdayPassCount;
    }

    public void setYesterdayPassCount(List<FeePassCountHour> yesterdayPassCount) {
        this.yesterdayPassCount = yesterdayPassCount;
    }
}
