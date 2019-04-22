package com.zhangwenit.mybatis.demo.demo;

import com.zhangwenit.mybatis.demo.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/16 6:48 PM
 * @Version 1.0
 **/
public class FirstDemo {

    public static void main(String[] args) throws IOException {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryBuilderDemo.getSqlSessionFactory();
//        SqlSessionDemo.getUserById(sqlSessionFactory);
//        SqlSessionDemo.getPersonById(sqlSessionFactory);
//        SqlSessionDemo.savePerson(sqlSessionFactory);
        //对于同一个enum，使用两个不同的类型转换器
//        SqlSessionDemo.selectPersonMapById(sqlSessionFactory);
//        SqlSessionDemo.updatePersonName();
//        SqlSessionDemo.joinIdAndName();
//        SqlSessionDemo.updatePriceByNumericScale();
//        SqlSessionDemo.selectOneByColumn();
//        SqlSessionDemo.selectByIdUseConstructor();
//        SqlSessionDemo.selectByIdUseAssociation();
//        SqlSessionDemo.selectByIdUseAssociationInnerResultMap();
//        SqlSessionDemo.selectPersonWithLogList();
//        SqlSessionDemo.selectPersonWithLogListUseInnerJoin();
//        SqlSessionDemo.selectUseDiscriminator();
//        SqlSessionDemo.selectByCriteriaUseChoose();
//        SqlSessionDemo.selectByCriteriaUseWhere();
//        SqlSessionDemo.selectByCriteriaUseTrimPrefix();
//        SqlSessionDemo.updatePersonUseSet();
//        SqlSessionDemo.updatePersonUseTrimSuffix();
//        SqlSessionDemo.selectByIdListUseForeach();
//        SqlSessionDemo.selectUseBind();
//        SqlSessionDemo.selectAllUseMap();
        SqlSessionDemo.selectUseRowBounds();
    }


    public static void test() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        System.out.println(sqlSessionFactory);


        SqlSession sqlSession = sqlSessionFactory.openSession();

        String userId = "123";

        //会自动关闭资源你，如果该类实现了 Closeable 接口
        try (sqlSession) {
            User user = sqlSession.selectOne("com.zhangwenit.mybatis.demo.mapper.example.UserMapper.selectUserById", userId);
            System.out.println(user);
        }

        System.out.println("end");
    }
}