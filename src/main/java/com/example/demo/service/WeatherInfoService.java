package com.example.demo.service;


import com.example.demo.dao.MonWeatherInfoDao;
import com.example.demo.dao.SysPlazaDao;
import com.example.demo.domain.MonWeatherInfo;
import com.example.demo.domain.SysPlaza;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangfs on 2017/6/28. helloWorld
 */
@Service
public class WeatherInfoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherInfoService.class);


    @Autowired
    private SysPlazaDao sysPlazaDao;
    @Autowired
    private MonWeatherInfoDao monWeatherInfoDao;

    public SysPlaza findSysPlaza(String plazaNo) {
        return sysPlazaDao.findByPlaNo(plazaNo);
    }

    public MonWeatherInfo findMonWeatherInfolist(String plano) {
        MonWeatherInfo monWeatherInfo=monWeatherInfoDao.findAllByPlaNo(plano);
        if(null!=monWeatherInfo){
            SysPlaza sysPlaza=sysPlazaDao.findByPlaNo(monWeatherInfo.getPlaNo());
            if(null!=sysPlaza){
                monWeatherInfo.setPlaName(sysPlaza.getPlaName());
            }
        }
        return monWeatherInfo;
    }


}
