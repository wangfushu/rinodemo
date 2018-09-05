package com.xmrbi.rinoWeb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;


/**
 * Created by Administrator on 2017-07-31.
 * 监控事故统计
 */

@Entity
@Table(name = "mon_monitortotal")
public class MonMonitorTotal {


    @Id
    @Column(name = "kid")
    private Long kID;

    @Column(name = "plano")
    private String plaNo;

    @Column(name = "planame")
    private String plaName;
    @Column(name = "eventtype")
    private String eventType;

    @Column(name = "eventnum")
    private Integer eventNum;
    @Column(name = "updatetime")
    private Date updateTime;

    public Long getkID() {
        return kID;
    }

    public void setkID(Long kID) {
        this.kID = kID;
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

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Integer getEventNum() {
        return eventNum;
    }

    public void setEventNum(Integer eventNum) {
        this.eventNum = eventNum;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
