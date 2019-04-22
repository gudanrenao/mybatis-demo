package com.zhangwenit.mybatis.demo.model;

import com.zhangwenit.mybatis.demo.enums.ColorEnum;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;
import org.apache.ibatis.type.EnumTypeHandler;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/16 7:03 PM
 * @Version 1.0
 **/
//@Alias("person2")
public class Person {

    private Long id;

    private Integer sex;

    /**
     * 使用自定义类型处理器解析
     */
    private User user;
    /**
     * 可以映射为String{@link EnumTypeHandler},或int{@link EnumOrdinalTypeHandler}，选择不同的类型转换器
     * 使用默认的 EnumTypeHandler 映射
     */
    private ColorEnum color;
    /**
     * 如果想同样的 Enum 既映射成字符串又映射成整形 ，就必须要显式地为那些 SQL 语句设置要使用的类型处理器
     * 使用默认的 EnumOrdinalTypeHandler 映射
     */
    private ColorEnum color2;

    private String name;

    private String userId;
    /**
     * 使用numericScale可以指定保存时的小数位数
     */
    private Double price;

    /**
     * 使用association关联 懒加载 个人信息
     */
    private PersonalInfo personalInfo;

    public Person() {
    }

    public Person(@Param("id") Long id, @Param("sex") Integer sex, @Param("name") String name) {
        this.id = id;
        this.sex = sex;
        this.name = name;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ColorEnum getColor() {
        return color;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }

    public ColorEnum getColor2() {
        return color2;
    }

    public void setColor2(ColorEnum color2) {
        this.color2 = color2;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", sex=" + sex +
                ", user=" + user +
                ", color=" + color +
                ", color2=" + color2 +
                ", name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", price=" + price +
                ", personalInfo=" + personalInfo +
                '}';
    }
}