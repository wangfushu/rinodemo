package com.xmrbi.rinoWeb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;


/**
 * Created by Administrator on 2017-07-31.
 * APP用户信息统计表
 */

@Entity
@Table(name = "KF_APPTOTALINFO")
public class KFAPPTotalInfo {


    @Id
    @Column(name = "apptype")
    private Long aPPType;

    @Column(name = "newregscount")
    private Integer newRegsCount;

    @Column(name = "activecountintoday")
    private Integer activeCountInToday;
    @Column(name = "regscount")
    private Integer regsCount;

    @Column(name = "updatetime")
    private Date updateTime;

    public Long getaPPType() {
        return aPPType;
    }

    public void setaPPType(Long aPPType) {
        this.aPPType = aPPType;
    }

    public Integer getNewRegsCount() {
        return newRegsCount;
    }

    public void setNewRegsCount(Integer newRegsCount) {
        this.newRegsCount = newRegsCount;
    }

    public Integer getActiveCountInToday() {
        return activeCountInToday;
    }

    public void setActiveCountInToday(Integer activeCountInToday) {
        this.activeCountInToday = activeCountInToday;
    }

    public Integer getRegsCount() {
        return regsCount;
    }

    public void setRegsCount(Integer regsCount) {
        this.regsCount = regsCount;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
