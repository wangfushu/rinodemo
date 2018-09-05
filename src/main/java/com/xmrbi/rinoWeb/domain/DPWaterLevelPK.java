package com.xmrbi.rinoWeb.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class DPWaterLevelPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "plano")
    private String plaNo;//路段

    @Id
    @Column(name = "direction")
    private String pumpingId;//泵房编号

    public DPWaterLevelPK(String plaNo, String pumpingId) {
        this.plaNo = plaNo;
        this.pumpingId = pumpingId;
    }
}
