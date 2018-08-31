package com.example.demo.dao;


import com.example.demo.domain.SysPlaza;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wangfushu on 2017/9/21.
 * hello
 */
public interface SysPlazaDao extends JpaRepository<SysPlaza, String> {
    SysPlaza findByPlaNo(String plano);
}
