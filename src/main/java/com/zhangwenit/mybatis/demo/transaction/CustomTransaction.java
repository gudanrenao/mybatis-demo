package com.zhangwenit.mybatis.demo.transaction;

import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.Transaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Description 自定义事务管理器 todo 待实现并使用
 * @Author ZWen
 * @Date 2019/4/18 1:27 PM
 * @Version 1.0
 **/
public class CustomTransaction implements Transaction {

    protected Connection connection;
    protected DataSource dataSource;
    protected TransactionIsolationLevel level;
    /**
     * MEMO: We are aware of the typo. See #941
     */
    protected boolean autoCommit;

    public CustomTransaction(Connection conn) {
        this.connection = conn;
    }

    public CustomTransaction(DataSource dataSource, TransactionIsolationLevel desiredLevel, boolean desiredAutoCommit) {
        this.dataSource = dataSource;
        this.level = desiredLevel;
        this.autoCommit = desiredAutoCommit;
    }

    /**
     * Retrieve inner database connection
     *
     * @return DataBase connection
     * @throws SQLException
     */
    @Override
    public Connection getConnection() throws SQLException {
        return null;
    }

    /**
     * Commit inner database connection.
     *
     * @throws SQLException
     */
    @Override
    public void commit() throws SQLException {

    }

    /**
     * Rollback inner database connection.
     *
     * @throws SQLException
     */
    @Override
    public void rollback() throws SQLException {

    }

    /**
     * Close inner database connection.
     *
     * @throws SQLException
     */
    @Override
    public void close() throws SQLException {

    }

    /**
     * Get transaction timeout if set
     *
     * @throws SQLException
     */
    @Override
    public Integer getTimeout() throws SQLException {
        return null;
    }
}