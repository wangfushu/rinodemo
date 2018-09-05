package com.xmrbi.rinoWeb.domain;

import javax.persistence.*;
import java.sql.Date;


/**
 * Created by Administrator on 2017-07-31.
 * 车道通行灯情况表
 */

@Entity
@Table(name = "Mon_RoadLamp")
@IdClass(MonRoadLampPK.class)
public class MonRoadLamp {


    @Id
    @Column(name = "kid")
    private Date detectTime;
    @Id
    @Column(name = "plano")
    private String plaNo;

    @Column(name = "planame")
    private String plaName;

    @Column(name = "inroadlamp")
    private Integer inRoadLamp;

    @Column(name = "outroadlamp")
    private String outRoadLamp;

    @Column(name = "updatetime")
    private Date updateTime;

    public Date getDetectTime() {
        return detectTime;
    }

    public void setDetectTime(Date detectTime) {
        this.detectTime = detectTime;
    }

    public String getPlaNo() {
        return plaNo;
    }

    public void setPlaNo(String plaNo) {
        this.plaNo = plaNo;
    }

    public String getPlaName() {
        return plaName;
    }

    public void setPlaName(String plaName) {
        this.plaName = plaName;
    }

    public Integer getInRoadLamp() {
        return inRoadLamp;
    }

    public void setInRoadLamp(Integer inRoadLamp) {
        this.inRoadLamp = inRoadLamp;
    }

    public String getOutRoadLamp() {
        return outRoadLamp;
    }

    public void setOutRoadLamp(String outRoadLamp) {
        this.outRoadLamp = outRoadLamp;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
