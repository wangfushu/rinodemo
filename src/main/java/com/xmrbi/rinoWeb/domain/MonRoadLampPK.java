package com.xmrbi.rinoWeb.domain;

import javax.persistence.*;
import java.sql.Date;


/**
 * Created by Administrator on 2017-07-31.
 *
 */


public class MonRoadLampPK implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "kid")
    private Date detectTime;
    @Id
    @Column(name = "plano")
    private String plaNo;

    public MonRoadLampPK(Date detectTime, String plaNo) {
        this.detectTime = detectTime;
        this.plaNo = plaNo;
    }

    public MonRoadLampPK() {
    }
}
