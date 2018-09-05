package com.xmrbi.rinoWeb.dao;


import com.xmrbi.rinoWeb.domain.MonWeatherInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wangfushu on 2017/9/21.
 * hello
 */
public interface MonWeatherInfoDao extends JpaRepository<MonWeatherInfo, String> {

    MonWeatherInfo findAllByPlaNo(String plano);
}
