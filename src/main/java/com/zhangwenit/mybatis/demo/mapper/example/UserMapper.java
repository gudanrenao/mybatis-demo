package com.zhangwenit.mybatis.demo.mapper.example;

import com.zhangwenit.mybatis.demo.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/16 6:53 PM
 * @Version 1.0
 **/
public interface UserMapper {

    User selectUserById(@Param("id") String id);

    @Select("select * from user where id = #{id}")
    User selectById(String id);
}