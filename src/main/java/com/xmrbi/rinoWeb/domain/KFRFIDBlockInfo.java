package com.xmrbi.rinoWeb.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "KF_RFIDBLOCKINFO")
@IdClass(KFRFIDBlockInfoPK.class)
public class KFRFIDBlockInfo {

    @Id
    @Column(name = "plano")
    private String plaNo;//路段

    @Id
    @Column(name = "direction")
    private Integer direction;//通行方向

    @Id
    @Column(name = "blockno")
    private Integer blockNo;//区间编号

    @Column(name = "planame")
    private String plaName;//路段名称

    @Column(name = "speed")
    private Double speed;//路段速度

    @Column(name = "speedclass")
    private Integer speedclass;//速度等级

    @Column(name = "points")
    private String points;//地图上线路经纬度信息

    @Column(name = "updatetime")
    private Date upDateTime;//更新时间

    public String getPlaNo() {
        return plaNo;
    }

    public void setPlaNo(String plaNo) {
        this.plaNo = plaNo;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Integer getBlockNo() {
        return blockNo;
    }

    public void setBlockNo(Integer blockNo) {
        this.blockNo = blockNo;
    }

    public String getPlaName() {
        return plaName;
    }

    public void setPlaName(String plaName) {
        this.plaName = plaName;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getSpeedclass() {
        return speedclass;
    }

    public void setSpeedclass(Integer speedclass) {
        this.speedclass = speedclass;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public Date getUpDateTime() {
        return upDateTime;
    }

    public void setUpDateTime(Date upDateTime) {
        this.upDateTime = upDateTime;
    }
}
