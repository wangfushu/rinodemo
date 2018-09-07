package com.xmrbi.rinoWeb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_yearfeesubmittype")
public class TYearFeeSubmitType {
    @Id
    @Column(name = "FID")
    private Integer fId;

    @Column(name = "fupdatetime")
    private Integer fUpdateTime;

    @Column(name = "fsubmittypename")
    private String fSubmitTypeName;

    @Column(name = "fdaterealtimefee")
    private double fDateRealtimeFee;

    @Column(name = "linesign")
    private Integer lineSign;

    @Column(name = "fsubmittype")
    private Integer fSubmitType;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Integer getfUpdateTime() {
        return fUpdateTime;
    }

    public void setfUpdateTime(Integer fUpdateTime) {
        this.fUpdateTime = fUpdateTime;
    }

    public String getfSubmitTypeName() {
        return fSubmitTypeName;
    }

    public void setfSubmitTypeName(String fSubmitTypeName) {
        this.fSubmitTypeName = fSubmitTypeName;
    }

    public double getfDateRealtimeFee() {
        return fDateRealtimeFee;
    }

    public void setfDateRealtimeFee(double fDateRealtimeFee) {
        this.fDateRealtimeFee = fDateRealtimeFee;
    }

    public Integer getLineSign() {
        return lineSign;
    }

    public void setLineSign(Integer lineSign) {
        this.lineSign = lineSign;
    }

    public Integer getfSubmitType() {
        return fSubmitType;
    }

    public void setfSubmitType(Integer fSubmitType) {
        this.fSubmitType = fSubmitType;
    }
}
