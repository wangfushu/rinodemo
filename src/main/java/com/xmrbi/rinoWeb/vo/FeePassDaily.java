package com.xmrbi.rinoWeb.vo;

import com.xmrbi.rinoWeb.utils.StringUtil;

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
 * @Date: 2018-09-11 14:44
 */
public class FeePassDaily {
    private String plaNo;//路段
    private String plaName;//路段名称
    private Integer inPassCounts;//进岛车流量(时)
    private Integer outPassCounts;//出岛车流量(时)
    private Double mtcFee;//累计金额（次费）
    private String mtcFeeString;//累计金额（次费）
    private String TotalTime;//时间

    public String getTotalTime() {
        return TotalTime;
    }

    public void setTotalTime(String totalTime) {
        TotalTime = totalTime;
    }

    public String getPlaNo() {
        return plaNo;
    }

    public void setPlaNo(String plaNo) {
        this.plaNo = plaNo;
    }

    public String getPlaName() {
        return plaName;
    }

    public void setPlaName(String plaName) {
        this.plaName = plaName;
    }

    public Integer getInPassCounts() {
        return inPassCounts;
    }

    public void setInPassCounts(Integer inPassCounts) {
        this.inPassCounts = inPassCounts;
    }

    public Integer getOutPassCounts() {
        return outPassCounts;
    }

    public void setOutPassCounts(Integer outPassCounts) {
        this.outPassCounts = outPassCounts;
    }

    public String getMtcFeeString() {
        return StringUtil.getFormat(6,this.mtcFee.intValue());
    }


    public void setMtcFeeString(String mtcFeeString) {
        this.mtcFeeString = mtcFeeString;
    }

    public Double getMtcFee() {
        return mtcFee;
    }

    public void setMtcFee(Double mtcFee) {
        this.mtcFee = mtcFee;
    }
}
