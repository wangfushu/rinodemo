package com.xmrbi.rinoWeb.dao;

import com.xmrbi.rinoWeb.domain.TyphoonInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TyphoonInfoDao extends JpaRepository<TyphoonInfo, String> {
    TyphoonInfo findByTyphoonName(String name);
}
