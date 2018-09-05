package com.xmrbi.rinoWeb.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "mon_tunnelfan")
@IdClass(MonTunnelFanPK.class)
public class MonTunnelFan {

    @Id
    @Column(name = "plano")
    private String plaNo;//路段

    @Id
    @Column(name = "direction")
    private String deviceId;//设备编号

    @Id
    @Column(name = "blockno")
    private Date detectTime;//检测时间

    @Column(name = "planame")
    private String plaName;//路段名称

    @Column(name = "speed")
    private String DeviceName;//设备名称

    @Column(name = "lng")
    private String lng;
    @Column(name = "lat")
    private String lat;

    @Column(name = "runtime")
    private String runTime;//检测时间

    @Column(name = "totalruntime")
    private String totalRunTime;//当前运行时长
    @Column(name = "ontime")
    private String onTime;//最后开机时间

    @Column(name = "devicestatus")
    private Integer deviceStatus;//设备状态

    @Column(name = "updatetime")
    private Date upDateTime;//更新时间

    public String getPlaNo() {
        return plaNo;
    }

    public void setPlaNo(String plaNo) {
        this.plaNo = plaNo;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Date getDetectTime() {
        return detectTime;
    }

    public void setDetectTime(Date detectTime) {
        this.detectTime = detectTime;
    }

    public String getPlaName() {
        return plaName;
    }

    public void setPlaName(String plaName) {
        this.plaName = plaName;
    }

    public String getDeviceName() {
        return DeviceName;
    }

    public void setDeviceName(String deviceName) {
        DeviceName = deviceName;
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

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getTotalRunTime() {
        return totalRunTime;
    }

    public void setTotalRunTime(String totalRunTime) {
        this.totalRunTime = totalRunTime;
    }

    public String getOnTime() {
        return onTime;
    }

    public void setOnTime(String onTime) {
        this.onTime = onTime;
    }

    public Integer getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(Integer deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public Date getUpDateTime() {
        return upDateTime;
    }

    public void setUpDateTime(Date upDateTime) {
        this.upDateTime = upDateTime;
    }
}
