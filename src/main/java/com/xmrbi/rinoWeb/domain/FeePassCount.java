package com.xmrbi.rinoWeb.domain;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "fee_passcount")
@IdClass(FeePassCountPK.class)
public class FeePassCount {

    @Id
    @Column(name = "plano")
    private String plaNo;//路段

    @Id
    @Column(name = "direction")
    private Integer direction;//通行方向

    @Id
    @Column(name = "totaltime")
    private Date totalTime;//统计时间

    @Column(name = "planame")
    private String plaName;//路段名称

    @Column(name = "passcounts")
    private Integer passCounts;//

    @Column(name = "totalcounts")
    private Integer totalCounts;

    @Column(name = "updatetime")
    private Date upDateTime;//更新时间

    public String getPlaNo() {
        return plaNo;
    }

    public void setPlaNo(String plaNo) {
        this.plaNo = plaNo;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Date getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Date totalTime) {
        this.totalTime = totalTime;
    }

    public String getPlaName() {
        return plaName;
    }

    public void setPlaName(String plaName) {
        this.plaName = plaName;
    }

    public Integer getPassCounts() {
        return passCounts;
    }

    public void setPassCounts(Integer passCounts) {
        this.passCounts = passCounts;
    }

    public Integer getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(Integer totalCounts) {
        this.totalCounts = totalCounts;
    }

    public Date getUpDateTime() {
        return upDateTime;
    }

    public void setUpDateTime(Date upDateTime) {
        this.upDateTime = upDateTime;
    }
}
