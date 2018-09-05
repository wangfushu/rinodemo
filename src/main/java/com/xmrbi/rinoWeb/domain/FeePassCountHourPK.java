package com.xmrbi.rinoWeb.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

public class FeePassCountHourPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "plano")
    private String plaNo;//路段

    @Id
    @Column(name = "totaltime")
    private Date totalTime;//统计时间

    public FeePassCountHourPK(String plaNo, Date totalTime) {
        this.plaNo = plaNo;
        this.totalTime = totalTime;
    }
}
