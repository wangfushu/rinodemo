package com.xmrbi.rinoWeb.domain;

import javax.persistence.*;
import java.sql.Date;

@Embeddable
public class HighRptFeePK {
    @Column(name = "stationid")
    private String stationID;//收费站编号

    @Column(name = "fyear")
    private String fYear;//统计年份

    @Column(name = "totaltime")
    private Date totalTime;//统计时间

    public String getStationID() {
        return stationID;
    }

    public void setStationID(String stationID) {
        this.stationID = stationID;
    }

    public String getfYear() {
        return fYear;
    }

    public void setfYear(String fYear) {
        this.fYear = fYear;
    }

    public Date getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Date totalTime) {
        this.totalTime = totalTime;
    }

}
