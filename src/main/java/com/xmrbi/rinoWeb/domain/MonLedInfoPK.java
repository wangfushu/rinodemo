package com.xmrbi.rinoWeb.domain;

import javax.persistence.*;


/**
 * Created by Administrator on 2017-07-31.
 *
 */


public class MonLedInfoPK implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "plano")
    private String plaNo;
    @Id
    @Column(name = "ledid")
    private Integer lEDID;
    @Id
    @Column(name = "sendid")
    private Integer sendID;
    @Id
    @Column(name = "itemid")
    private Integer ttemID;

    public MonLedInfoPK(String plaNo, Integer lEDID, Integer sendID, Integer ttemID) {
        this.plaNo = plaNo;
        this.lEDID = lEDID;
        this.sendID = sendID;
        this.ttemID = ttemID;
    }

    public MonLedInfoPK() {
    }
}
