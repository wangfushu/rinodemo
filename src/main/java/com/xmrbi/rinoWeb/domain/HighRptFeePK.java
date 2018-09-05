package com.xmrbi.rinoWeb.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

public class HighRptFeePK implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "stationid")
    private String stationID;//收费站编号
    @Id
    @Column(name = "fyear")
    private String fYear;//统计年份
    @Id
    @Column(name = "totaltime")
    private Date totalTime;//统计时间

    public HighRptFeePK(String stationID, String fYear, Date totalTime) {
        this.stationID = stationID;
        this.fYear = fYear;
        this.totalTime = totalTime;
    }
}
