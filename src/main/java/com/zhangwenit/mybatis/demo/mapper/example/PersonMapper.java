package com.zhangwenit.mybatis.demo.mapper.example;

import com.zhangwenit.mybatis.demo.criteria.PersonCriteria;
import com.zhangwenit.mybatis.demo.dto.PersonDto;
import com.zhangwenit.mybatis.demo.model.Person;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/16 6:53 PM
 * @Version 1.0
 **/
public interface PersonMapper {

    Person selectById(Long id);

    /**
     * 使用 ResultMap转换
     *
     * @param id
     * @return
     */
    Person selectMapById(Long id);

    int savePerson(Person person);

    int updatePersonUser(@Param("id") Long id, @Param("user") String user);

    List<HashMap<String, Object>> joinIdAndName();

    int updatePriceByNumericScale(@Param("id") Long id, @Param("price") Double price);

    /**
     * 通过任何一列从表中 select 数据
     *
     * @param column 列名
     * @param value  列值
     * @return
     */
    Person selectOneByColumn(@Param("column") String column, @Param("value") String value);

    /**
     * ResultMap 使用 Constructor 构造
     *
     * @param id
     * @return
     */
    Person selectByIdUseConstructor(Long id);

    /**
     * ResultMap 使用 association 懒加载个人信息
     *
     * @param id
     * @return
     */
    Person selectByIdUseAssociation(Long id);

    /**
     * ResultMap 使用 association嵌套resultMap 查询
     *
     * @param id
     * @return
     */
    Person selectByIdUseAssociationInnerResultMap(Long id);

    /**
     * 使用collection的嵌套select查询 子查询多个sql请求
     *
     * @param id
     * @return
     */
    PersonDto selectPersonWithLogList(Long id);

    /**
     * 使用collection嵌套结果映射 多表join
     *
     * @param id
     * @return
     */
    PersonDto selectPersonWithLogListUseInnerJoin(Long id);

    /**
     * 鉴别器
     *
     * @param id
     * @return
     */
    Object selectUseDiscriminator(Long id);

    List<Person> selectByCriteriaUseChoose(PersonCriteria personCriteria);

    List<Person> selectByCriteriaUseWhere(PersonCriteria personCriteria);

    List<Person> selectByCriteriaUseTrimPrefix(PersonCriteria personCriteria);

    int updatePersonUseSet(Person person);

    int updatePersonUseTrimSuffix(Person person);

    List<Person> selectByIdListUseForeach(@Param("ids") List<Long> ids);

    /**
     * 使用bind 将like字段的值前后加%
     *
     * @param criteria
     * @return
     */
    List<Person> selectUseBind(PersonCriteria criteria);

    /**
     * selectMap:它会将返回的对象的其中一个属性作为 key 值，将对象作为 value 值，从而将多结果集转为 Map 类型值
     *
     * @return
     */
    @MapKey("name")
    Map<String, Person> selectAllUseMap();

    List<Person> selectUseRowBounds(RowBounds rowBounds);
}