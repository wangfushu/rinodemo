package com.example.demo.dao;

import com.example.demo.domain.SysDictionary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SysDictionaryDao extends JpaRepository<SysDictionary ,Long> {
    List<SysDictionary> findByDictName(String dictName);
}
