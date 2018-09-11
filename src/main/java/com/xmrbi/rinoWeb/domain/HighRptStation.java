package com.xmrbi.rinoWeb.domain;

import com.xmrbi.rinoWeb.utils.StringUtil;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "high_rptstation")
@IdClass(HighRptStationPK.class)
public class HighRptStation {
    @Id
    @Column(name = "stationid")
    private String stationID;//收费站编号

    @Id
    @Column(name = "totaltime")
    private Date totalTime;//统计时间

    @Basic
    @Column(name = "stationname")
    private String stationName;//收费站名称

    @Basic
    @Column(name = "MTCFEE")
    private Double mtcFee;//MTC收费金额

    @Basic
    @Column(name = "ETCFEE")
    private Double etcFee;//ETC收费金额

    @Basic
    @Column(name = "getfee")
    private Double getFee;//累计收费金额

    @Basic
    @Column(name = "outpasscount")
    private int outPassCount;//出口数量

    @Basic
    @Column(name = "entpasscount")
    private int entPassCoutn;//进口数量

    @Basic
    @Column(name = "updatetime")
    private Date upDateTime;//更新时间

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Double getGetFee() {
        return getFee;
    }

    public void setGetFee(Double getFee) {
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

    public Double getMtcFee() {
        return mtcFee;
    }

    public void setMtcFee(Double mtcFee) {
        this.mtcFee = mtcFee;
    }

    public Double getEtcFee() {
        return etcFee;
    }

    public void setEtcFee(Double etcFee) {
        this.etcFee = etcFee;
    }

    public Date getUpDateTime() {
        return upDateTime;
    }

    public void setUpDateTime(Date upDateTime) {
        this.upDateTime = upDateTime;
    }

    public String getStationID() {
        return stationID;
    }

    public void setStationID(String stationID) {
        this.stationID = stationID;
    }

    public Date getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Date totalTime) {
        this.totalTime = totalTime;
    }

    @Transient
    private String mtcFeeString;//MTC收费金额
    @Transient
    private String etcFeeString;//ETC收费金额
    @Transient
    private String getFeeString;//累计收费金额
    @Transient
    private String outPassCountString;//出口数量
    @Transient
    private String entPassCoutnString;//进口数量

    public void setMtcFeeString(String mtcFeeString) {
        this.mtcFeeString = StringUtil.getFormat(6,this.mtcFee.intValue());
    }

    public void setEtcFeeString(String etcFeeString) {
        this.etcFeeString = StringUtil.getFormat(6,this.etcFee.intValue());
    }

    public void setGetFeeString(String getFeeString) {
        this.getFeeString = StringUtil.getFormat(6,this.getFee.intValue());
    }

    public void setOutPassCountString(String outPassCountString) {
        this.outPassCountString = StringUtil.getFormat(6,this.outPassCount);
    }

    public void setEntPassCoutnString(String entPassCoutnString) {
        this.entPassCoutnString = StringUtil.getFormat(6,this.entPassCoutn);
    }

    public String getMtcFeeString() {
        return mtcFeeString;
    }
    public String getEtcFeeString() {
        return etcFeeString;
    }
    public String getGetFeeString() {
        return getFeeString;
    }
    public String getOutPassCountString() {
        return outPassCountString;
    }

    public String getEntPassCoutnString() {
        return entPassCoutnString;
    }
    /*  @Transient
    public String  getOutPassCountString() {
        return StringUtil.getFormat(6,this.outPassCount);
    }
    @Transient
    public String  getEntPassCoutnString() {
        return StringUtil.getFormat(6,this.entPassCoutn);
    }
    @Transient
    public String  getMtcFeeString() {
        return StringUtil.getFormat(6,mtcFee.intValue());
    }
    @Transient
    public String  getGetFeeString() {
        return StringUtil.getFormat(6,this.getFee.intValue());
    }
    @Transient
    public String  getEtcFeeString() {
        return StringUtil.getFormat(6,this.etcFee.intValue());
    }*/
}
