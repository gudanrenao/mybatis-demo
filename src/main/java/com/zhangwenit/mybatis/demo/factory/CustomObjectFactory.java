package com.zhangwenit.mybatis.demo.factory;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;
import java.util.Properties;

/**
 * @Description MyBatis 每次创建结果对象的新实例时，它都会使用一个对象工厂（ObjectFactory）实例来完成。
 * 默认的对象工厂需要做的仅仅是实例化目标类，要么通过默认构造方法，要么在参数映射存在的时候通过参数构造方法来实例化。
 * 如果想覆盖对象工厂的默认行为，则可以通过创建自己的对象工厂来实现
 * 需要在mybatis-config.xml配置
 * @Author ZWen
 * @Date 2019/4/18 9:59 AM
 * @Version 1.0
 **/
public class CustomObjectFactory extends DefaultObjectFactory {

    private String someProperty;

    @Override
    public <T> T create(Class<T> type) {
        return super.create(type);
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        return super.create(type, constructorArgTypes, constructorArgs);
    }

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        this.someProperty = properties.getProperty("someProperty", "-1");
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return super.isCollection(type);
    }
}