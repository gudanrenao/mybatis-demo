package com.zhangwenit.mybatis.demo.plugins;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * @Description 自定义插件
 * <pre>
 * MyBatis 允许你在已映射语句执行过程中的某一点进行拦截调用。默认情况下，MyBatis 允许使用插件来拦截的方法调用包括：
 *      Executor (update, query, flushStatements, commit, rollback, getTransaction, close, isClosed)
 *      ParameterHandler (getParameterObject, setParameters)
 *      ResultSetHandler (handleResultSets, handleOutputParameters)
 *      StatementHandler (prepare, parameterize, batch, update, query)
 * </pre>
 * 通过 MyBatis 提供的强大机制，使用插件是非常简单的，只需实现 Interceptor 接口，并指定想要拦截的方法签名即可
 * @Author ZWen
 * @Date 2019/4/18 12:07 PM
 * @Version 1.0
 **/
@Intercepts({
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class})
})
public class ExamplePlugin implements Interceptor {

    private String someProperty;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("ExamplePlugin intercept begin... someProperty is " + someProperty);
        Object proceed = invocation.proceed();
        System.out.println("ExamplePlugin intercept end... someProperty is " + someProperty);
        return proceed;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        this.someProperty = properties.getProperty("someProperty", "null");
    }
}