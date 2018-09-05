package com.xmrbi.rinoWeb.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class KFRFIDBlockInfoPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "plano")
    private String plaNo;//路段

    @Id
    @Column(name = "direction")
    private Integer direction;//通行方向

    @Id
    @Column(name = "blockno")
    private Integer blockNo;//区间编号

    public KFRFIDBlockInfoPK(String plaNo, Integer direction, Integer blockNo) {
        this.plaNo = plaNo;
        this.direction = direction;
        this.blockNo = blockNo;
    }
}
