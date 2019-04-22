package com.zhangwenit.mybatis.demo.dto;

import com.zhangwenit.mybatis.demo.enums.ColorEnum;

/**
 * @Description 使用鉴别器映射
 * @Author ZWen
 * @Date 2019/4/19 9:15 PM
 * @Version 1.0
 **/
public class PersonUseDiscriminatorDto {

    private Long id;
    private String name;
    private ColorEnum color;


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

    @Override
    public String toString() {
        return "PersonUseDiscriminatorDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color=" + color +
                '}';
    }
}