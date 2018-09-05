package com.xmrbi.rinoWeb.domain;

import javax.persistence.*;
import java.sql.Date;


/**
 * Created by Administrator on 2017-07-31.
 * 施工作业信息表
 */

@Entity
@Table(name = "mon_ledinfo")
@IdClass(MonLedInfoPK.class)
public class MonLedInfo {


    @Id
    @Column(name = "plano")
    private String plaNo;
    @Id
    @Column(name = "ledid")
    private Integer lEDID;
    @Id
    @Column(name = "sendid")
    private Integer sendID;
    @Id
    @Column(name = "itemid")
    private Integer ttemID;


    @Column(name = "planame")
    private String plaName;


    @Column(name = "ledname")
    private String lEDName;

    @Column(name = "lng")
    private String lng;
    @Column(name = "lat")
    private String lat;


    @Column(name = "sno")
    private Integer sNo;

    @Column(name = "infotype")
    private String tnfoType;
    @Column(name = "infourl")
    private String tnfoUrl;

    @Column(name = "devicestatus")
    private Integer deviceStatus;
    @Column(name = "vidiconid")
    private Integer vidiconID;

    @Column(name = "updatetime")
    private Date updateTime;

    public String getPlaNo() {
        return plaNo;
    }

    public void setPlaNo(String plaNo) {
        this.plaNo = plaNo;
    }

    public Integer getlEDID() {
        return lEDID;
    }

    public void setlEDID(Integer lEDID) {
        this.lEDID = lEDID;
    }

    public Integer getSendID() {
        return sendID;
    }

    public void setSendID(Integer sendID) {
        this.sendID = sendID;
    }

    public Integer getTtemID() {
        return ttemID;
    }

    public void setTtemID(Integer ttemID) {
        this.ttemID = ttemID;
    }

    public String getPlaName() {
        return plaName;
    }

    public void setPlaName(String plaName) {
        this.plaName = plaName;
    }

    public String getlEDName() {
        return lEDName;
    }

    public void setlEDName(String lEDName) {
        this.lEDName = lEDName;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public Integer getsNo() {
        return sNo;
    }

    public void setsNo(Integer sNo) {
        this.sNo = sNo;
    }

    public String getTnfoType() {
        return tnfoType;
    }

    public void setTnfoType(String tnfoType) {
        this.tnfoType = tnfoType;
    }

    public String getTnfoUrl() {
        return tnfoUrl;
    }

    public void setTnfoUrl(String tnfoUrl) {
        this.tnfoUrl = tnfoUrl;
    }

    public Integer getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(Integer deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public Integer getVidiconID() {
        return vidiconID;
    }

    public void setVidiconID(Integer vidiconID) {
        this.vidiconID = vidiconID;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
