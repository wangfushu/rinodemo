package com.xmrbi.rinoWeb.domain;

import javax.persistence.*;
import java.sql.Date;

public class HighFeeMonthPK implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "stationid")
    private String stationID;//收费站编号

    @Id
    @Column(name = "fyear")
    private String fYear;//统计年份

    @Id
    @Column(name = "fmonth")
    private String fMonth;//统计月份

    public HighFeeMonthPK(String stationID, String fYear, String fMonth) {
        this.stationID = stationID;
        this.fYear = fYear;
        this.fMonth = fMonth;
    }
}
