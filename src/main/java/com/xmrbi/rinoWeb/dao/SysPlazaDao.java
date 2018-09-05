package com.xmrbi.rinoWeb.dao;


import com.xmrbi.rinoWeb.domain.SysPlaza;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wangfushu on 2017/9/21.
 * hello
 */
public interface SysPlazaDao extends JpaRepository<SysPlaza, String> {
    SysPlaza findByPlaNo(String plano);
}
