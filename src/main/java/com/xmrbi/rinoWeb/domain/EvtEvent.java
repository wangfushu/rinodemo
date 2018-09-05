package com.xmrbi.rinoWeb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;


/**
 * Created by Administrator on 2017-07-31.
 * 事件信息表
 */

@Entity
@Table(name = "evt_Event")
public class EvtEvent {


    @Id
    @Column(name = "kid")
    private Long kID;

    @Column(name = "plano")
    private String plaNo;

    @Column(name = "planame")
    private String plaName;
    @Column(name = "direction")
    private Integer direction;

    @Column(name = "startdate")
    private Date startDate;
    @Column(name = "eventsource")
    private String eventSource;
    @Column(name = "eventtype")
    private String eventType;
    @Column(name = "eventdesc")
    private String eventDesc;
    @Column(name = "createtime")
    private Date createTime;
    @Column(name = "longititude")
    private String longititude;

    @Column(name = "latitude")
    private String latitude;

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

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getEventSource() {
        return eventSource;
    }

    public void setEventSource(String eventSource) {
        this.eventSource = eventSource;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLongititude() {
        return longititude;
    }

    public void setLongititude(String longititude) {
        this.longititude = longititude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
