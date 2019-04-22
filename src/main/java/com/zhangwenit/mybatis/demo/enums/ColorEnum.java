package com.zhangwenit.mybatis.demo.enums;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/18 10:44 AM
 * @Version 1.0
 **/
@SuppressWarnings("all")
public enum ColorEnum {

    RED(1),
    BLUE(2),
    WHITE(3),
    BLACK(4);

    private final int index;

    ColorEnum(int index) {
        this.index = index;
    }
}
