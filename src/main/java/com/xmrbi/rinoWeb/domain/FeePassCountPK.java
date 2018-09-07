package com.xmrbi.rinoWeb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;


public class FeePassCountPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "plano")
    private String plaNo;//路段

    @Id
    @Column(name = "direction")
    private Integer direction;//通行方向

    @Id
    @Column(name = "totaltime")
    private Date totalTime;//统计时间

    public FeePassCountPK(String plaNo, Integer direction, Date totalTime) {
        this.plaNo = plaNo;
        this.direction = direction;
        this.totalTime = totalTime;
    }
}
