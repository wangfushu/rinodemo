package com.xmrbi.rinoWeb.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

public class MonTunnelFanPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "plano")
    private String plaNo;//路段

    @Id
    @Column(name = "direction")
    private String deviceId;//设备编号

    @Id
    @Column(name = "blockno")
    private Date detectTime;//检测时间

    public MonTunnelFanPK(String plaNo, String deviceId, Date detectTime) {
        this.plaNo = plaNo;
        this.deviceId = deviceId;
        this.detectTime = detectTime;
    }
}
