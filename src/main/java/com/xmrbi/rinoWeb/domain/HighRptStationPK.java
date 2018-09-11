package com.xmrbi.rinoWeb.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

public class HighRptStationPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "stationid")
    private String stationID;//收费站编号

    @Id
    @Column(name = "totaltime")
    private Date totalTime;//统计时间

    public HighRptStationPK(String stationID, Date totalTime) {
        this.stationID = stationID;
        this.totalTime = totalTime;
    }

    public HighRptStationPK() {
    }
}
