package com.zhangwenit.mybatis.demo.model;

/**
 * @Description 个人信息
 * @Author ZWen
 * @Date 2019/4/19 4:45 PM
 * @Version 1.0
 **/
public class PersonalInfo {

    private Long id;

    private int age;

    private String alias;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "PersonalInfo{" +
                "id=" + id +
                ", age=" + age +
                ", alias='" + alias + '\'' +
                '}';
    }
}