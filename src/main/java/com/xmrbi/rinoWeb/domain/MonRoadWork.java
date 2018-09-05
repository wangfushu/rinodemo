package com.xmrbi.rinoWeb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;


/**
 * Created by Administrator on 2017-07-31.
 * 施工作业信息表
 */

@Entity
@Table(name = "MON_ROADWORK")
public class MonRoadWork {


    @Id
    @Column(name = "kid")
    private Long kID;

    @Column(name = "plano")
    private String plaNo;

    @Column(name = "planame")
    private String plaName;
    @Column(name = "worktype")
    private String workType;

    @Column(name = "direction")
    private Integer direction;

    @Column(name = "workstatus")
    private String workStatus;
    @Column(name = "workroad")
    private String workRoad;
    @Column(name = "startdate")
    private Date startDate;
    @Column(name = "enddate")
    private Date endDate;

    @Column(name = "headmanager")
    private String headManager;

    @Column(name = "headphone")
    private String headPhone;
    @Column(name = "workdesc")
    private String workDesc;

    @Column(name = "createtime")
    private Date createTime;
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

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public String getWorkRoad() {
        return workRoad;
    }

    public void setWorkRoad(String workRoad) {
        this.workRoad = workRoad;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getHeadManager() {
        return headManager;
    }

    public void setHeadManager(String headManager) {
        this.headManager = headManager;
    }

    public String getHeadPhone() {
        return headPhone;
    }

    public void setHeadPhone(String headPhone) {
        this.headPhone = headPhone;
    }

    public String getWorkDesc() {
        return workDesc;
    }

    public void setWorkDesc(String workDesc) {
        this.workDesc = workDesc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
