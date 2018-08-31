package com.example.demo.domain;

import javax.persistence.*;
import java.sql.Date;


/**
 * Created by Administrator on 2017-07-31.
 */

@Entity
@Table(name = "MON_WEATHERINFO")
public class MonWeatherInfo {

    @Id
    @Column(name = "PLANO")
    private String plaNo;

    @Column(name = "DEVICEID")
    private String deviceId;
    @Column(name = "DETECTTIME")
    private Date detectTime;
    @Column(name = "windspeed")
    private Float windSpeed;
    @Column(name = "wind")
    private String wind;
    @Column(name = "temperature")
    private Float temperature;
    @Column(name = "humidity")
    private Float humidity;
    @Column(name = "visibility")
    private Float visibility;
    @Column(name = "rainfall")
    private Float rainfall;
    @Column(name = "windvalue")
    private Long windValue;

    /**
     * 网点名称
     */
    @Transient
    private String plaName;

    public String getPlaName() {
        return plaName;
    }

    public void setPlaName(String plaName) {
        this.plaName = plaName;
    }

    public String getPlaNo() {
        return plaNo;
    }

    public void setPlaNo(String plaNo) {
        this.plaNo = plaNo;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Date getDetectTime() {
        return detectTime;
    }

    public void setDetectTime(Date detectTime) {
        this.detectTime = detectTime;
    }

    public Float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    public Float getVisibility() {
        return visibility;
    }

    public void setVisibility(Float visibility) {
        this.visibility = visibility;
    }

    public Float getRainfall() {
        return rainfall;
    }

    public void setRainfall(Float rainfall) {
        this.rainfall = rainfall;
    }

    public Long getWindValue() {
        return windValue;
    }

    public void setWindValue(Long windValue) {
        this.windValue = windValue;
    }
}
