package com.zhangwenit.mybatis.demo.demo;

import com.zhangwenit.mybatis.demo.mapper.example.PersonUseAnnotationMapper;
import com.zhangwenit.mybatis.demo.model.Person;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

/**
 * 注解sql
 */
public class AnnotationSqlDemo {

    public static void main(String[] args) throws Exception {
//        selectListUseConstructor();
        selectUseSqlProvider();
    }

    public static void selectListUseConstructor() throws IOException {
        try (SqlSession sqlSession = SqlSessionFactoryBuilderDemo.getSqlSessionFactory().openSession()) {
            PersonUseAnnotationMapper annotationMapper = sqlSession.getMapper(PersonUseAnnotationMapper.class);
            List<Person> list = annotationMapper.selectListUseConstructor();
            System.out.println("result is " + list);
        }
    }

    public static void selectUseSqlProvider() throws IOException {
        try (SqlSession sqlSession = SqlSessionFactoryBuilderDemo.getSqlSessionFactory().openSession()) {
            PersonUseAnnotationMapper annotationMapper = sqlSession.getMapper(PersonUseAnnotationMapper.class);
            String name = "person";
            Integer sex = 0;
            List<Person> list = annotationMapper.selectUseSqlProvider(name, sex);
            System.out.println("result is " + list);
        }
    }

}