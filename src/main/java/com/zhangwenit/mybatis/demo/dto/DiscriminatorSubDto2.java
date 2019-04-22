package com.zhangwenit.mybatis.demo.dto;

import com.zhangwenit.mybatis.demo.enums.ColorEnum;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/19 11:39 PM
 * @Version 1.0
 **/
public class DiscriminatorSubDto2 {

    private Long id;
    private String name;
    private ColorEnum color;
    private String blackValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getBlackValue() {
        return blackValue;
    }

    public void setBlackValue(String blackValue) {
        this.blackValue = blackValue;
    }

    @Override
    public String toString() {
        return "DiscriminatorSubDto2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color=" + color +
                ", blackValue='" + blackValue + '\'' +
                '}';
    }
}