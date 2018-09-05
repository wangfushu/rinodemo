package com.xmrbi.rinoWeb.domain;

import javax.persistence.*;
import java.sql.Date;


/**
 * Created by Administrator on 2017-07-31.
 *
 */

@Entity
@Table(name = "FEE_MTCFEE")
@IdClass(FeeMTCFeePK.class)
public class FeeMTCFee {

    /**
     * 网点编号
     * 0001-厦门大桥
     * 0002-海沧大桥
     * 0003-集美大桥
     * 0004-杏林大桥
     */
    @Id
    @Column(name = "PLANO")
    private String plaNo;

    @Id
    @Column(name = "laneno")
    private String laneNo;
    @Id
    @Column(name = "tolldate")
    private Date tollDate;
    @Column(name = "paytype")
    private String payType;

    @Column(name = "passfee")
    private Double passFee;
    @Column(name = "vehiclekindno")
    private String vehicleKindNo;
    @Column(name = "vehiclekindname")
    private String vehicleKindName;
    @Column(name = "vehiclekinddesc")
    private String vehicleKindDesc;
    @Column(name = "totalpasscount")
    private Long totalPassCount;
    @Column(name = "totalfee")
    private Double totalFee;

    @Column(name = "updatetime")
    private Date updateTime;

    /**
     * 网点名称
     */

    @Column(name = "planame")
    private String plaName;

    public String getPlaNo() {
        return plaNo;
    }

    public void setPlaNo(String plaNo) {
        this.plaNo = plaNo;
    }

    public String getLaneNo() {
        return laneNo;
    }

    public void setLaneNo(String laneNo) {
        this.laneNo = laneNo;
    }

    public Date getTollDate() {
        return tollDate;
    }

    public void setTollDate(Date tollDate) {
        this.tollDate = tollDate;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Double getPassFee() {
        return passFee;
    }

    public void setPassFee(Double passFee) {
        this.passFee = passFee;
    }

    public String getVehicleKindNo() {
        return vehicleKindNo;
    }

    public void setVehicleKindNo(String vehicleKindNo) {
        this.vehicleKindNo = vehicleKindNo;
    }

    public String getVehicleKindName() {
        return vehicleKindName;
    }

    public void setVehicleKindName(String vehicleKindName) {
        this.vehicleKindName = vehicleKindName;
    }

    public String getVehicleKindDesc() {
        return vehicleKindDesc;
    }

    public void setVehicleKindDesc(String vehicleKindDesc) {
        this.vehicleKindDesc = vehicleKindDesc;
    }

    public Long getTotalPassCount() {
        return totalPassCount;
    }

    public void setTotalPassCount(Long totalPassCount) {
        this.totalPassCount = totalPassCount;
    }


    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getPlaName() {
        return plaName;
    }

    public void setPlaName(String plaName) {
        this.plaName = plaName;
    }

    public Double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Double totalFee) {
        this.totalFee = totalFee;
    }
}
