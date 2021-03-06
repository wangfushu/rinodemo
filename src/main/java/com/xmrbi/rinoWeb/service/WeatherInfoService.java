package com.xmrbi.rinoWeb.service;


import com.xmrbi.rinoWeb.dao.MonWeatherInfoDao;
import com.xmrbi.rinoWeb.dao.SysPlazaDao;
import com.xmrbi.rinoWeb.dao.TyphoonInfoDao;
import com.xmrbi.rinoWeb.domain.MonWeatherInfo;
import com.xmrbi.rinoWeb.domain.SysPlaza;
import com.xmrbi.rinoWeb.domain.TyphoonInfo;
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
    @Autowired
    private TyphoonInfoDao typhoonInfoDao;

    public SysPlaza findSysPlaza(String plazaNo) {
        return sysPlazaDao.findByPlaNo(plazaNo);
    }

    public TyphoonInfo findTyphoonInfo(String name){
        return typhoonInfoDao.findByTyphoonName(name);
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
