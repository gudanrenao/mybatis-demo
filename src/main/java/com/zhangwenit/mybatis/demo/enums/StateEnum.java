package com.zhangwenit.mybatis.demo.enums;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/18 11:28 AM
 * @Version 1.0
 **/
@SuppressWarnings("all")
public enum StateEnum {

    UNPAY("未支付"),
    PAYED("已支付"),
    CANCEL("已取消");

    private final String msg;

    StateEnum(String msg) {
        this.msg = msg;
    }
}
