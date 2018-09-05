package com.xmrbi.rinoWeb.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "fee_mtcmonth")
public class FeeMTCMonth {

    /*@Id
    @Column(name = "plano")
    private String plaNo;//路段*/

    @EmbeddedId
    private FeeMTCMonthPK id;

    @Column(name = "planame")
    private String plaName;//路段名称

   /* @Column(name = "fyear")
    private String fYear;//统计年份

    @Column(name = "fmonth")
    private String fMonth;//统计月份*/

    @Column(name = "MTCFEE")
    private double mtcFee;//MTC收费金额

    @Column(name = "totaltime")
    private Date totalTime;//统计时间

    @Column(name = "updatetime")
    private Date upDateTime;//更新时间

    public String getPlaName() {
        return plaName;
    }

    public void setPlaName(String plaName) {
        this.plaName = plaName;
    }

    public double getMtcFee() {
        return mtcFee;
    }

    public void setMtcFee(double mtcFee) {
        this.mtcFee = mtcFee;
    }

    public Date getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Date totalTime) {
        this.totalTime = totalTime;
    }

    public Date getUpDateTime() {
        return upDateTime;
    }

    public void setUpDateTime(Date upDateTime) {
        this.upDateTime = upDateTime;
    }
}
