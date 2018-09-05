package com.xmrbi.rinoWeb.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "fee_passcounttotal")
@IdClass(FeePassCountTotalPK.class)
public class FeePassCountTotal {

    @Id
    @Column(name = "plano")
    private String plaNo;//路段

    @Id
    @Column(name = "totaltime")
    private Date totalTime;//统计时间

    @Column(name = "planame")
    private String plaName;//路段名称

    @Column(name = "designflow")
    private Integer designFlow;//设计车流量

    @Column(name = "countaverger")
    private Integer countAverger;//本月日均车流量

    @Column(name = "maxcount")
    private Integer maxCount;//本月最高车流量数

    @Column(name = "maxcounthour")
    private String maxCountHour;//本月最高车流量时间（小时）

    @Column(name = "mincount")
    private Integer minCount;//本月最低车流量数

    @Column(name = "mincounthour")
    private String minCountHour;//本月最低车流量时间（小时）

    @Column(name = "updatetime")
    private Date upDateTime;//更新时间

    public String getPlaName() {
        return plaName;
    }

    public void setPlaName(String plaName) {
        this.plaName = plaName;
    }


    public Date getUpDateTime() {
        return upDateTime;
    }

    public void setUpDateTime(Date upDateTime) {
        this.upDateTime = upDateTime;
    }

    public String getPlaNo() {
        return plaNo;
    }

    public void setPlaNo(String plaNo) {
        this.plaNo = plaNo;
    }

    public Date getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Date totalTime) {
        this.totalTime = totalTime;
    }

    public Integer getDesignFlow() {
        return designFlow;
    }

    public void setDesignFlow(Integer designFlow) {
        this.designFlow = designFlow;
    }

    public Integer getCountAverger() {
        return countAverger;
    }

    public void setCountAverger(Integer countAverger) {
        this.countAverger = countAverger;
    }

    public Integer getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(Integer maxCount) {
        this.maxCount = maxCount;
    }

    public String getMaxCountHour() {
        return maxCountHour;
    }

    public void setMaxCountHour(String maxCountHour) {
        this.maxCountHour = maxCountHour;
    }

    public Integer getMinCount() {
        return minCount;
    }

    public void setMinCount(Integer minCount) {
        this.minCount = minCount;
    }

    public String getMinCountHour() {
        return minCountHour;
    }

    public void setMinCountHour(String minCountHour) {
        this.minCountHour = minCountHour;
    }
}
