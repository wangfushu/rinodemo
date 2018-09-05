package com.xmrbi.rinoWeb.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "DP_WaterLevel")
@IdClass(DPWaterLevelPK.class)
public class DPWaterLevel {

    @Id
    @Column(name = "plano")
    private String plaNo;//路段

    @Id
    @Column(name = "direction")
    private String pumpingId;//泵房编号


    @Column(name = "planame")
    private String plaName;//路段名称

    @Column(name = "pumpingname")
    private String pumpingName;//泵房名称

    @Column(name = "devicestatus")
    private String deviceStatus;//设备状态

    @Column(name = "lng")
    private String lng;
    @Column(name = "lat")
    private String lat;

    @Column(name = "waterlevel")
    private Double waterLevel;//水位

    @Column(name = "waterwarn")
    private Double waterWarn;//警戒水位
    @Column(name = "watercapacity")
    private Double waterCapacity;//容量水位


    @Column(name = "updatetime")
    private Date upDateTime;//更新时间

    public String getPlaNo() {
        return plaNo;
    }

    public void setPlaNo(String plaNo) {
        this.plaNo = plaNo;
    }

    public String getPumpingId() {
        return pumpingId;
    }

    public void setPumpingId(String pumpingId) {
        this.pumpingId = pumpingId;
    }

    public String getPlaName() {
        return plaName;
    }

    public void setPlaName(String plaName) {
        this.plaName = plaName;
    }

    public String getPumpingName() {
        return pumpingName;
    }

    public void setPumpingName(String pumpingName) {
        this.pumpingName = pumpingName;
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
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

    public Double getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(Double waterLevel) {
        this.waterLevel = waterLevel;
    }

    public Double getWaterWarn() {
        return waterWarn;
    }

    public void setWaterWarn(Double waterWarn) {
        this.waterWarn = waterWarn;
    }

    public Double getWaterCapacity() {
        return waterCapacity;
    }

    public void setWaterCapacity(Double waterCapacity) {
        this.waterCapacity = waterCapacity;
    }

    public Date getUpDateTime() {
        return upDateTime;
    }

    public void setUpDateTime(Date upDateTime) {
        this.upDateTime = upDateTime;
    }
}
