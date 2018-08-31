package com.example.demo.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Sys_Dictionary")
public class SysDictionary implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String dictName;
    private String dictCode;
    private String dictValue;
    private String updateTime;
    private String addTime;
    private long version;

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
    @Column(name = "dict_name",columnDefinition="varchar(100) Default NULL")
    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    @Basic
    @Column(name = "dict_code",columnDefinition="varchar(100) Default NULL")
    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    @Basic
    @Column(name = "dict_value",columnDefinition="varchar(100) Default NULL")
    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    @Basic
    @Column(name = "update_time",columnDefinition="varchar(100) Default NULL")
    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "add_time",columnDefinition="varchar(100) Default NULL")
    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    @Version
    @Column(name = "version",columnDefinition="bigint Default 0")
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
