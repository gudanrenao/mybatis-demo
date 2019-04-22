package com.zhangwenit.mybatis.demo.criteria;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/20 8:43 AM
 * @Version 1.0
 **/
public class PersonCriteria {

    private Long id;

    private String name;

    private Integer sex;

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "PersonCriteria{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}