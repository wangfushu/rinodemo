package com.xmrbi.rinoWeb.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

public class FeeETCFeePK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "plano")
    private String plaNo;//路段

    @Id
    @Column(name = "laneno")
    private String laneNo;//车道号

    @Id
    @Column(name = "TOllDATE")
    private Date tollDate;//统计时间

    public FeeETCFeePK(String plaNo, String laneNo, Date tollDate) {
        this.plaNo = plaNo;
        this.laneNo = laneNo;
        this.tollDate = tollDate;
    }
}
