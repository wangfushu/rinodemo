package com.xmrbi.rinoWeb.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class FeePassCountHourPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "plano")
    private String plaNo;//路段

    @Id
    @Column(name = "totalTime")
    private java.util.Date totalTime;//统计时间

    @Id
    @Column(name = "direction")
    private Integer direction;//进出方向

    public FeePassCountHourPK(String plaNo, Date totalTime, Integer direction) {
        this.plaNo = plaNo;
        this.totalTime = totalTime;
        this.direction = direction;
    }
}
