package com.xmrbi.rinoWeb.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "fee_vtypecount")
public class FeeVTypeCount {

    @Id
    @Column(name = "FID")
    private Integer fId;//路段

    @Column(name = "plano")
    private String plaNo;//路段

    @Column(name = "totaltime")
    private Date totalTime;//统计时间

    @Column(name = "planame")
    private String plaName;//路段名称

    @Column(name = "roadtype")
    private Integer roadType;//车道类型:0-年费道,1-现金道

    @Column(name = "direction")
    private Integer direction;//通行方向

    @Column(name = "vtotalcounts")
    private String vTotalCounts;//车型当天累计车流量

    @Column(name = "vtype")
    private String vType;//车辆类型

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


    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public String getvTotalCounts() {
        return vTotalCounts;
    }

    public void setvTotalCounts(String vTotalCounts) {
        this.vTotalCounts = vTotalCounts;
    }

    public String getvType() {
        return vType;
    }

    public void setvType(String vType) {
        this.vType = vType;
    }
}
