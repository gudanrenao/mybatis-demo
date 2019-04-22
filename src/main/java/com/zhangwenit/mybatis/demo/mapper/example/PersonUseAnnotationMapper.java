package com.zhangwenit.mybatis.demo.mapper.example;

import com.zhangwenit.mybatis.demo.model.Person;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * @Description 使用注解
 * @Author ZWen
 * @Date 2019/4/16 6:53 PM
 * @Version 1.0
 **/
//@CacheNamespace(eviction = LruCache.class, size = 512)

/**
 * 参照另外一个命名空间的缓存来使用。属性有：value, name。如果你使用了这个注解，你应设置 value 或者 name 属性的其中一个。value 属性用于指定 Java 类型而指定命名空间（命名空间名就是指定的 Java 类型的全限定名），name 属性（这个属性仅在MyBatis 3.4.2以上版本生效）直接指定了命名空间的名字
 */
@CacheNamespaceRef(value = PersonMapper.class)
public interface PersonUseAnnotationMapper {

    //todo @Property

    Person selectUseProperty(String name);

    /**
     * 使用结果对象的构造方法构造结果
     *
     * @return
     */
    @ConstructorArgs({
            @Arg(id = true, column = "id", name = "id"),
            @Arg(column = "name", name = "name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Arg(column = "sex", name = "sex")
    })
    @Select("select id,`name`,sex from person")
    List<Person> selectListUseConstructor();

    @ResultMap("com.zhangwenit.mybatis.demo.mapper.example.PersonMapper.customPerson")
    @SelectProvider(type = PersonSqlProvider.class)
    List<Person> selectUseSqlProvider(@Param("name") String name, @Param("sex") Integer sex);


    /**
     * 动态sql
     * ProviderMethodResolver 3.5.1新特性
     */
    class PersonSqlProvider implements ProviderMethodResolver {

        public static String selectUseSqlProvider(@Param("name") String name, @Param("sex") Integer sex) {
            return new SQL() {
                {
                    SELECT("*");
                    FROM("person");
                    if (name != null) {
                        WHERE("name like '%" + name + "%'");
                    }
                    if (sex != null) {
                        WHERE("sex = #{sex}");
                    }
                }
            }.toString();
        }

    }

}