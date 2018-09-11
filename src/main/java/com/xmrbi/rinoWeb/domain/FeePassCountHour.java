package com.xmrbi.rinoWeb.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "fee_passcounthour")
@IdClass(FeePassCountHourPK.class)
public class FeePassCountHour {

    @Id
    @Column(name = "plano")
    private String plaNo;//路段

    @Id
    @Column(name = "totalTime")
    private Date totalTime;//统计时间

    @Id
    @Column(name = "direction")
    private Integer direction;//进出方向

    @Column(name = "planame")
    private String plaName;//路段名称

    @Column(name = "passcounts")
    private Integer passCounts;//进岛车流量(时)

    @Column(name = "updatetime")
    private Date upDateTime;//更新时间

    public String getPlaNo() {
        return plaNo;
    }

    public void setPlaNo(String plaNo) {
        this.plaNo = plaNo;
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

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Integer getPassCounts() {
        return passCounts;
    }

    public void setPassCounts(Integer passCounts) {
        this.passCounts = passCounts;
    }

    public Date getUpDateTime() {
        return upDateTime;
    }

    public void setUpDateTime(Date upDateTime) {
        this.upDateTime = upDateTime;
    }
}
