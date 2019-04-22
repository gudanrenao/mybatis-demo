package com.zhangwenit.mybatis.demo.model;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/16 7:03 PM
 * @Version 1.0
 **/
public class User {

    private String id;

    private String name;

    private String name2;

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getId() {
        return id;
    }

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", name2='" + name2 + '\'' +
                '}';
    }
}