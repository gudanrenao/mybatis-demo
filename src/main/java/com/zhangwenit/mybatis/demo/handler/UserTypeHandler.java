package com.zhangwenit.mybatis.demo.handler;

import com.zhangwenit.mybatis.demo.model.User;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description 自定义类型处理器，需要在mybatis-config.xml->typeHandlers添加typeHandler
 * 1.在类型处理器的类上（TypeHandler class）增加一个 @MappedTypes 注解来指定与其关联的 Java 类型列表。
 * 如果在 javaType(mybatis-config.xml->typeHandlers->typeHandler->javaType) 属性中也同时指定，则注解方式将被忽略
 * 2.在类型处理器的类上增加一个 @MappedJdbcTypes 注解来指定与其关联的 JDBC 类型列表。
 * 如果在 jdbcType(mybatis-config.xml->typeHandlers->typeHandler->jdbcType) 属性中也同时指定，则注解方式将被忽略
 *
 * todo 泛型类型处理器待使用
 * @Author ZWen
 * @Date 2019/4/17 11:43 PM
 * @Version 1.0
 **/
@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(User.class)
public class UserTypeHandler extends BaseTypeHandler<User> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, User parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getName());
    }

    @Override
    public User getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return parseUser(rs.getString(columnName));
    }

    @Override
    public User getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return parseUser(rs.getString(columnIndex));
    }

    @Override
    public User getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return parseUser(cs.getString(columnIndex));
    }

    private User parseUser(String str) {
        return new User(str);
    }
}