package com.zhangwenit.mybatis.demo.transaction;

import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

/**
 * @Description 自定义事务管理器工厂
 * @Author ZWen
 * @Date 2019/4/18 1:27 PM
 * @Version 1.0
 **/
public class CustomTransactionFactory implements TransactionFactory {

    private String someProperty;

    /**
     * Sets transaction factory custom properties.
     * 在 XML 中配置的属性在实例化之后将会被传递给 setProperties() 方法
     *
     * @param props
     */
    @Override
    public void setProperties(Properties props) {
        this.someProperty = props.getProperty("someProperty", "null");
    }

    /**
     * Creates a {@link Transaction} out of an existing connection.
     *
     * @param conn Existing database connection
     * @return Transaction
     * @since 3.1.0
     */
    @Override
    public Transaction newTransaction(Connection conn) {
        return new CustomTransaction(conn);
    }

    /**
     * Creates a {@link Transaction} out of a datasource.
     *
     * @param dataSource DataSource to take the connection from
     * @param level      Desired isolation level
     * @param autoCommit Desired autocommit
     * @return Transaction
     * @since 3.1.0
     */
    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new CustomTransaction(dataSource, level, autoCommit);
    }
}