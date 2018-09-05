package com.xmrbi.rinoWeb.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

public class FeeMTCMonthPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "plano")
    private String plaNo;//路段

    @Id
    @Column(name = "fyear")
    private String fYear;//统计年份

    @Id
    @Column(name = "fmonth")
    private String fMonth;//统计月份

    public FeeMTCMonthPK(String plaNo, String fYear, String fMonth) {
        this.plaNo = plaNo;
        this.fYear = fYear;
        this.fMonth = fMonth;
    }
}
