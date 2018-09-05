package com.xmrbi.rinoWeb.domain;

import javax.persistence.*;
import java.sql.Date;

@Embeddable
public class FeeETCFeePK {

    @Column(name = "plano")
    private String plaNo;//路段

    @Column(name = "laneno")
    private String laneNo;//车道号

    @Column(name = "TOllDATE")
    private Date tollDate;//统计时间

    public String getPlaNo() {
        return plaNo;
    }

    public void setPlaNo(String plaNo) {
        this.plaNo = plaNo;
    }


    public String getLaneNo() {
        return laneNo;
    }

    public void setLaneNo(String laneNo) {
        this.laneNo = laneNo;
    }


    public Date getTollDate() {
        return tollDate;
    }

    public void setTollDate(Date tollDate) {
        this.tollDate = tollDate;
    }

}
