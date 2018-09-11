package com.xmrbi.rinoWeb.domain;

import javax.persistence.*;

/**
 * Created by Administrator on 2017-07-31.
 */

@Entity
@Table(name = "SYS_PLAZA")
public class SysPlaza {

    @Id
    @Column(name = "PLANO")
    private String plaNo;

  /*  @Basic
    @Column(name = "PLAORDERNO")
    private Long plaOrderNo;*/
    @Basic
    @Column(name = "PLANAME")
    private String plaName;
 /*   @Basic
    @Column(name = "PLACASHBANK")
    private String plaCashBank;
    @Basic
    @Column(name = "PLAPOSBANK")
    private String plaPosBank;
    @Basic
    @Column(name = "PLAREMARK")
    private String plaRemark;
    @Basic
    @Column(name = "PLAZIPCODE")
    private String plaZipCode;*/

    public String getPlaNo() {
        return plaNo;
    }

    public void setPlaNo(String plaNo) {
        this.plaNo = plaNo;
    }

  /*  public Long getPlaOrderNo() {
        return plaOrderNo;
    }

    public void setPlaOrderNo(Long plaOrderNo) {
        this.plaOrderNo = plaOrderNo;
    }*/

    public String getPlaName() {
        return plaName;
    }

    public void setPlaName(String plaName) {
        this.plaName = plaName;
    }

   /* public String getPlaCashBank() {
        return plaCashBank;
    }

    public void setPlaCashBank(String plaCashBank) {
        this.plaCashBank = plaCashBank;
    }

    public String getPlaPosBank() {
        return plaPosBank;
    }

    public void setPlaPosBank(String plaPosBank) {
        this.plaPosBank = plaPosBank;
    }

    public String getPlaRemark() {
        return plaRemark;
    }

    public void setPlaRemark(String plaRemark) {
        this.plaRemark = plaRemark;
    }

    public String getPlaZipCode() {
        return plaZipCode;
    }

    public void setPlaZipCode(String plaZipCode) {
        this.plaZipCode = plaZipCode;
    }*/

}
