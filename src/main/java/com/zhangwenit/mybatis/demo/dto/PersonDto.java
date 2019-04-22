package com.zhangwenit.mybatis.demo.dto;

import com.zhangwenit.mybatis.demo.enums.ColorEnum;
import com.zhangwenit.mybatis.demo.model.PersonLog;
import com.zhangwenit.mybatis.demo.model.PersonalInfo;

import java.util.List;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/19 7:06 PM
 * @Version 1.0
 **/
public class PersonDto {

    private Long id;
    private Integer sex;
    private String name;
    private ColorEnum color;
    /**
     * 使用association关联 懒加载 个人信息
     */
    private PersonalInfo personalInfo;
    /**
     * 使用collection 一对多查询
     */
    private List<PersonLog> logList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ColorEnum getColor() {
        return color;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public List<PersonLog> getLogList() {
        return logList;
    }

    public void setLogList(List<PersonLog> logList) {
        this.logList = logList;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "id=" + id +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                ", color=" + color +
                ", personalInfo=" + personalInfo +
                ", logList=" + logList +
                '}';
    }
}