package com.xmrbi.rinoWeb.domain;

import javax.persistence.*;
import java.sql.Date;


/**
 * Created by Administrator on 2017-07-31.
 *
 */


public class FeeMTCFeePK  implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 网点编号
     * 0001-厦门大桥
     * 0002-海沧大桥
     * 0003-集美大桥
     * 0004-杏林大桥
     */
    @Id
    @Column(name = "PLANO")
    private String plaNo;

    @Id
    @Column(name = "laneno")
    private String laneNo;
    @Id
    @Column(name = "tolldate")
    private Date tollDate;

    public FeeMTCFeePK() {
    }

    public FeeMTCFeePK(String plaNo, String laneNo, Date tollDate) {
        this.plaNo = plaNo;
        this.laneNo = laneNo;
        this.tollDate = tollDate;
    }
}
