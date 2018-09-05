package com.xmrbi.rinoWeb.domain;

import javax.persistence.*;
import java.sql.Date;

@Embeddable
public class HighFeeMonthPK {
    @Column(name = "stationid")
    private String stationID;//收费站编号

    @Basic
    @Column(name = "fyear")
    private String fYear;//统计年份

    @Basic
    @Column(name = "fmonth")
    private String fMonth;//统计月份

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

    public String getfMonth() {
        return fMonth;
    }

    public void setfMonth(String fMonth) {
        this.fMonth = fMonth;
    }
}
