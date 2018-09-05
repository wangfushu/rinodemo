package com.xmrbi.rinoWeb.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "FEE_ETCFEE")
public class FeeETCFee {

    @EmbeddedId
    private FeeETCFeePK id;//联合主键

    /*@Id
    @Column(name = "plano")
    private String plaNo;//路段
*/
    @Column(name = "planame")
    private String plaName;//路段名称

    /*@Column(name = "laneno")
    private String laneNo;//车道号*/

    @Column(name = "paytype")
    private String payType;//收费说明

    @Column(name = "vehiclekindno")
    private String vehicleKindNo;//车辆类型编号

    @Column(name = "vehiclekindname")
    private String vehicleKindName;//车型大类

    @Column(name = "vehiclekinddesc")
    private String vehicleKindDesc;//车型描述

    @Column(name = "totalpasscount")
    private String totalPassCount;//累计收费车辆数

    @Column(name = "passfee")
    private double passFee;//收费额

    /*@Column(name = "TOllDATE")
    private Date tollDate;//统计时间*/

    @Column(name = "updatetime")
    private Date upDateTime;//更新时间

    public String getPlaName() {
        return plaName;
    }

    public void setPlaName(String plaName) {
        this.plaName = plaName;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
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

    public String getTotalPassCount() {
        return totalPassCount;
    }

    public void setTotalPassCount(String totalPassCount) {
        this.totalPassCount = totalPassCount;
    }

    public double getPassFee() {
        return passFee;
    }

    public void setPassFee(double passFee) {
        this.passFee = passFee;
    }

    public Date getUpDateTime() {
        return upDateTime;
    }

    public void setUpDateTime(Date upDateTime) {
        this.upDateTime = upDateTime;
    }
}
