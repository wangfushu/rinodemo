package com.example.demo.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Typhoon_Info")
public class TyphoonInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String typhoonName;
    private String position;
    private String centralWind;
    private String maxSpeed;
    private String centralPressure;
    private long travelRate;

    @Id
    @Column(name = "id",columnDefinition="bigint ")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "typhoon_name",columnDefinition="varchar(100) Default NULL")
    public String getTyphoonName() {
        return typhoonName;
    }

    public void setTyphoonName(String typhoonName) {
        this.typhoonName = typhoonName;
    }

    @Basic
    @Column(name = "position",columnDefinition="varchar(100) Default NULL")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "central_wind",columnDefinition="int")
    public String getCentralWind() {
        return centralWind;
    }

    public void setCentralWind(String centralWind) {
        this.centralWind = centralWind;
    }

    @Basic
    @Column(name = "max_speed",columnDefinition="int")
    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Basic
    @Column(name = "central_pressure",columnDefinition="int")
    public String getCentralPressure() {
        return centralPressure;
    }

    public void setCentralPressure(String centralPressure) {
        this.centralPressure = centralPressure;
    }

    @Basic
    @Column(name = "travel_rate",columnDefinition="int")
    public long getTravelRate() {
        return travelRate;
    }

    public void setTravelRate(long travelRate) {
        this.travelRate = travelRate;
    }
}
