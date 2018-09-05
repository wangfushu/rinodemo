package com.xmrbi.rinoWeb.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "high_feemonth")
public class HighFeeMonth {
   /* @Id
    @Column(name = "stationid")
    private String stationID;//收费站编号*/

   @EmbeddedId
   private HighFeeMonthPK id;

    @Basic
    @Column(name = "stationname")
    private String stationName;//收费站名称

    /*@Basic
    @Column(name = "fyear")
    private String fYear;//统计年份

    @Basic
    @Column(name = "fmonth")
    private String fMonth;//统计月份*/

    @Basic
    @Column(name = "MTCFEE")
    private double mtcFee;//MTC收费金额

    @Basic
    @Column(name = "ETCFEE")
    private double etcFee;//ETC收费金额

    @Basic
    @Column(name = "totaltime")
    private Date totalTime;//统计时间

    @Basic
    @Column(name = "updatetime")
    private Date upDateTime;//更新时间

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public double getMtcFee() {
        return mtcFee;
    }

    public void setMtcFee(double mtcFee) {
        this.mtcFee = mtcFee;
    }

    public double getEtcFee() {
        return etcFee;
    }

    public void setEtcFee(double etcFee) {
        this.etcFee = etcFee;
    }

    public Date getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Date totalTime) {
        this.totalTime = totalTime;
    }

    public Date getUpDateTime() {
        return upDateTime;
    }

    public void setUpDateTime(Date upDateTime) {
        this.upDateTime = upDateTime;
    }

    public HighFeeMonthPK getId() {
        return id;
    }

    public void setId(HighFeeMonthPK id) {
        this.id = id;
    }
}
