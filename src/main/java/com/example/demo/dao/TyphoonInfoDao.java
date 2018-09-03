package com.example.demo.dao;

import com.example.demo.domain.MonWeatherInfo;
import com.example.demo.domain.TyphoonInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TyphoonInfoDao extends JpaRepository<TyphoonInfo, String> {
    TyphoonInfo findByTyphoonName(String name);
}
