package com.xmrbi.rinoWeb.domain;

import javax.persistence.*;
import java.sql.Date;

@Embeddable
public class FeeMTCMonthPK {

    @Column(name = "plano")
    private String plaNo;//路段

    @Column(name = "fyear")
    private String fYear;//统计年份

    @Column(name = "fmonth")
    private String fMonth;//统计月份

    public String getPlaNo() {
        return plaNo;
    }

    public void setPlaNo(String plaNo) {
        this.plaNo = plaNo;
    }

    public String getfYear() {
        return fYear;
    }

    public void setfYear(String fYear) {
        this.fYear = fYear;
    }

    public String getfMonth() {
        return fMonth;
    }

    public void setfMonth(String fMonth) {
        this.fMonth = fMonth;
    }

}
