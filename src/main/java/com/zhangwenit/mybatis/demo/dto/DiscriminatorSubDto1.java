package com.zhangwenit.mybatis.demo.dto;

import com.zhangwenit.mybatis.demo.enums.ColorEnum;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/19 11:39 PM
 * @Version 1.0
 **/
public class DiscriminatorSubDto1 {

    private Long id;
    private String name;
    private ColorEnum color;
    private String redValue;

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

    public String getRedValue() {
        return redValue;
    }

    public void setRedValue(String redValue) {
        this.redValue = redValue;
    }

    @Override
    public String toString() {
        return "DiscriminatorSubDto1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color=" + color +
                ", redValue='" + redValue + '\'' +
                '}';
    }
}