package com.xmrbi.rinoWeb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "fee_yearmonth")
public class FeeYearMonth {
    @Id
    @Column(name = "kid")
    private int kId;//主键

    public int getkId() {
        return kId;
    }

    public void setkId(int kId) {
        this.kId = kId;
    }

    public String getfYear() {
        return fYear;
    }

    public void setfYear(String fYear) {
        this.fYear = fYear;
    }

    public String getfMonth() {
        return fMonth;
    }

    public void setfMonth(String fMonth) {
        this.fMonth = fMonth;
    }

    public double getYearFee() {
        return yearFee;
    }

    public void setYearFee(double yearFee) {
        this.yearFee = yearFee;
    }

    public Date getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Date totalTime) {
        this.totalTime = totalTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Column(name = "fyear")
    private String fYear;//统计年份

    @Column(name = "fmonth")
    private String fMonth;//统计月份

    @Column(name = "yearfee")
    private double yearFee;//年费收费金额

    @Column(name = "totaltime")
    private Date totalTime;//统计时间

    @Column(name = "updatetime")
    private Date updateTime;//更新时间


}
