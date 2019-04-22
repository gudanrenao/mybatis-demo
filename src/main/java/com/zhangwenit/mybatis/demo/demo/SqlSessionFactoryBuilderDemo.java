package com.zhangwenit.mybatis.demo.demo;

import com.zhangwenit.mybatis.demo.handler.UserTypeHandler;
import com.zhangwenit.mybatis.demo.mapper.example.PersonMapper;
import com.zhangwenit.mybatis.demo.mapper.example.UserMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

/**
 * @Description //SqlSessionFactoryBuilder一旦创建了SqlSessionFactory后，就不再需要它了，所以它的最佳作用域是方法作用域
 * //SqlSessionFactory 一旦被创建就应该在应用的运行期间一直存在，没有任何理由丢弃它或重新创建另一个实例。
 * //使用 SqlSessionFactory 的最佳实践是在应用运行期间不要重复创建多次，多次重建 SqlSessionFactory 被视为一种代码“坏味道（bad smell）”。
 * //因此 SqlSessionFactory 的最佳作用域是应用作用域。 有很多方法可以做到，最简单的就是使用单例模式或者静态单例模式
 * @Author ZWen
 * @Date 2019/4/17 2:37 PM
 * @Version 1.0
 **/
public class SqlSessionFactoryBuilderDemo {


    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
//        return getWithConfiguration();
        return getWithProperties();
    }

    /**
     * 属性可以被传递到 SqlSessionFactoryBuilder.build()方法中
     *
     * @return
     * @throws IOException
     */
    private static SqlSessionFactory getWithProperties() throws IOException {
        String config = "mybatis-config.xml";
        String propertiesName = "mybatis-config.properties";
        Reader reader = Resources.getResourceAsReader(config);
        Properties properties = new Properties();
        try (InputStream inputStream = Resources.getResourceAsStream(propertiesName)) {
            properties.load(inputStream);
        }

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(reader, properties);
        return sqlSessionFactory;
    }

    /**
     * 直接使用配置类，进行配置
     *
     * @return
     */
    private static SqlSessionFactory getWithConfiguration() throws IOException {
//        Properties properties = Resources.getResourceAsProperties("mybatis-config.properties");
        DataSource dataSource = new PooledDataSource("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/zhangwenit?characterEncoding=utf-8&useSSL=false&useUnicode=true", "root", "123456");

        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.setCacheEnabled(true);
        configuration.setLazyLoadingEnabled(true);
        configuration.getTypeAliasRegistry().registerAliases("com.zhangwenit.mybatis.demo.dto");
        configuration.getTypeAliasRegistry().registerAliases("com.zhangwenit.mybatis.demo.model");
        configuration.getTypeAliasRegistry().registerAliases("com.zhangwenit.mybatis.demo.criteria");

        configuration.getTypeHandlerRegistry().register(UserTypeHandler.class);

        //todo Invalid bound statement
        configuration.addLoadedResource("mapper/PersonMapper.xml");
        configuration.addLoadedResource("mapper/UserMapper.xml");
        configuration.addMapper(PersonMapper.class);
        configuration.addMapper(UserMapper.class);
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = factoryBuilder.build(configuration);
        return sqlSessionFactory;
    }


}