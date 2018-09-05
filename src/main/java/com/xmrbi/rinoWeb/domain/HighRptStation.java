package com.xmrbi.rinoWeb.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "high_rptstation")
public class HighRptStation {
    /*@Id
    @Column(name = "stationid")
    private String stationID;//收费站编号*/
    @EmbeddedId
    private HighRptStationPK id;//联合主键

    @Basic
    @Column(name = "stationname")
    private String stationName;//收费站名称

    @Basic
    @Column(name = "MTCFEE")
    private double mtcFee;//MTC收费金额

    @Basic
    @Column(name = "ETCFEE")
    private double etcFee;//ETC收费金额

    @Basic
    @Column(name = "getfee")
    private double getFee;//累计收费金额

    @Basic
    @Column(name = "outpasscount")
    private int outPassCount;//累计收费金额

    @Basic
    @Column(name = "entpasscoutn")
    private int entPassCoutn;//累计收费金额

    /*@Basic
    @Column(name = "totaltime")
    private Date totalTime;//统计时间*/

    @Basic
    @Column(name = "updatetime")
    private Date upDateTime;//更新时间

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public double getGetFee() {
        return getFee;
    }

    public void setGetFee(double getFee) {
        this.getFee = getFee;
    }

    public int getOutPassCount() {
        return outPassCount;
    }

    public void setOutPassCount(int outPassCount) {
        this.outPassCount = outPassCount;
    }

    public int getEntPassCoutn() {
        return entPassCoutn;
    }

    public void setEntPassCoutn(int entPassCoutn) {
        this.entPassCoutn = entPassCoutn;
    }

    public double getMtcFee() {
        return mtcFee;
    }

    public void setMtcFee(double mtcFee) {
        this.mtcFee = mtcFee;
    }

    public double getEtcFee() {
        return etcFee;
    }

    public void setEtcFee(double etcFee) {
        this.etcFee = etcFee;
    }

    public Date getUpDateTime() {
        return upDateTime;
    }

    public void setUpDateTime(Date upDateTime) {
        this.upDateTime = upDateTime;
    }

    public HighRptStationPK getId() {
        return id;
    }

    public void setId(HighRptStationPK id) {
        this.id = id;
    }
}
