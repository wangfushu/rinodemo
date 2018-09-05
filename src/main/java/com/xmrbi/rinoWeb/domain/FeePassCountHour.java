package com.xmrbi.rinoWeb.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "fee_passcounthour")
@IdClass(FeePassCountHourPK.class)
public class FeePassCountHour {

    @Id
    @Column(name = "plano")
    private String plaNo;//路段

    @Id
    @Column(name = "totaltime")
    private Date totalTime;//统计时间

    @Column(name = "planame")
    private String plaName;//路段名称

    @Column(name = "roadtype")
    private Integer roadType;//车道类型:0-年费道,1-现金道

    @Column(name = "inpasscounts")
    private Integer inPassCounts;//进岛车流量(时)

    @Column(name = "outpasscounts")
    private Integer outPassCounts;//出岛车流量(时)

    @Column(name = "updatetime")
    private Date upDateTime;//更新时间

    public String getPlaName() {
        return plaName;
    }

    public void setPlaName(String plaName) {
        this.plaName = plaName;
    }


    public Date getUpDateTime() {
        return upDateTime;
    }

    public void setUpDateTime(Date upDateTime) {
        this.upDateTime = upDateTime;
    }

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

    public Integer getRoadType() {
        return roadType;
    }

    public void setRoadType(Integer roadType) {
        this.roadType = roadType;
    }

    public Integer getInPassCounts() {
        return inPassCounts;
    }

    public void setInPassCounts(Integer inPassCounts) {
        this.inPassCounts = inPassCounts;
    }

    public Integer getOutPassCounts() {
        return outPassCounts;
    }

    public void setOutPassCounts(Integer outPassCounts) {
        this.outPassCounts = outPassCounts;
    }
}
