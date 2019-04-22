package com.zhangwenit.mybatis.demo.demo;

import com.google.common.collect.Lists;
import com.zhangwenit.mybatis.demo.criteria.PersonCriteria;
import com.zhangwenit.mybatis.demo.dto.PersonDto;
import com.zhangwenit.mybatis.demo.enums.ColorEnum;
import com.zhangwenit.mybatis.demo.mapper.example.PersonMapper;
import com.zhangwenit.mybatis.demo.mapper.example.UserMapper;
import com.zhangwenit.mybatis.demo.model.Person;
import com.zhangwenit.mybatis.demo.model.User;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description //每个线程都应该有它自己的 SqlSession 实例。SqlSession 的实例不是线程安全的，因此是不能被共享的，所以它的最佳的作用域是请求或方法作用域。
 * // 绝对不能将 SqlSession 实例的引用放在一个类的静态域，甚至一个类的实例变量也不行。
 * // 也绝不能将 SqlSession 实例的引用放在任何类型的托管作用域中，比如 Servlet 框架中的 HttpSession。
 * // 如果你现在正在使用一种 Web 框架，要考虑 SqlSession 放在一个和 HTTP 请求对象相似的作用域中。
 * // 换句话说，每次收到的 HTTP 请求，就可以打开一个 SqlSession，返回一个响应，就关闭它。
 * // 这个关闭操作是很重要的，你应该把这个关闭操作放到 finally 块中以确保每次都能执行关闭
 * @Author ZWen
 * @Date 2019/4/17 2:49 PM
 * @Version 1.0
 **/
public class SqlSessionDemo {


    public static void getUserById(SqlSessionFactory sqlSessionFactory) {
        String userId = "1234";
        SqlSession session = sqlSessionFactory.openSession();
        try {
            //映射器是一些由你创建的、绑定你映射的语句的接口。映射器接口的实例是从 SqlSession 中获得的。
            // 因此从技术层面讲，任何映射器实例的最大作用域是和请求它们的 SqlSession 相同的。尽管如此，映射器实例的最佳作用域是方法作用域。 todo:为何？
            // 也就是说，映射器实例应该在调用它们的方法中被请求，用过之后即可丢弃。 并不需要显式地关闭映射器实例，尽管在整个请求作用域保持映射器实例也不会有什么问题，
            // 但是你很快会发现，像 SqlSession 一样，在这个作用域上管理太多的资源的话会难于控制。 为了避免这种复杂性，最好把映射器放在方法作用域内
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.selectById(userId);
            System.out.println(user);
        } finally {
            session.close();
        }
    }

    public static void getPersonById(SqlSessionFactory sqlSessionFactory) {
        Long personId = 6L;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PersonMapper mapper = session.getMapper(PersonMapper.class);
            Person person = mapper.selectById(personId);
            System.out.println(person);
        }
    }

    public static void selectPersonMapById(SqlSessionFactory sqlSessionFactory) {
        Long personId = 6L;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PersonMapper mapper = session.getMapper(PersonMapper.class);
            Person person = mapper.selectMapById(personId);
            System.out.println(person);
        }
        //测试 poolPingConnectionsNotUsedFor
//        SleepUtils.second(3);
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            PersonMapper mapper = session.getMapper(PersonMapper.class);
//            Person person = mapper.selectMapById(personId);
//            System.out.println(person);
//        }
    }

    public static void savePerson(SqlSessionFactory sqlSessionFactory) {
        Person person = new Person();
        person.setSex(0);
        person.setColor(ColorEnum.RED);
        person.setColor2(ColorEnum.WHITE);
        person.setUser(new User("testSave2"));
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PersonMapper mapper = session.getMapper(PersonMapper.class);
            int update = mapper.savePerson(person);
            System.out.println(update + "----" + person);
            session.commit();
        }
    }

    public static void updatePersonName() throws IOException {
        Long personId = 6L;
        String user = "demo : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        SqlSessionFactory factory = SqlSessionFactoryBuilderDemo.getSqlSessionFactory();
        try (SqlSession sqlSession = factory.openSession()) {
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            int update = personMapper.updatePersonUser(personId, user);
            sqlSession.commit();
            System.out.println("result is " + update);
        }
    }

    public static void joinIdAndName() throws IOException {
        try (SqlSession sqlSession = SqlSessionFactoryBuilderDemo.getSqlSessionFactory().openSession()) {
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            List<HashMap<String, Object>> list = personMapper.joinIdAndName();
            System.out.println("result is " + list);
        }
    }

    public static void updatePriceByNumericScale() throws IOException {
        try (SqlSession sqlSession = SqlSessionFactoryBuilderDemo.getSqlSessionFactory().openSession()) {
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            double price = 34.567;
            int update = personMapper.updatePriceByNumericScale(6L, price);
            sqlSession.commit();
            System.out.println("result is " + update);
        }
    }

    public static void selectOneByColumn() throws IOException {
        try (SqlSession sqlSession = SqlSessionFactoryBuilderDemo.getSqlSessionFactory().openSession()) {
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            Person person = personMapper.selectOneByColumn("name", "person_123");
            System.out.println("result is " + person);
        }
    }

    public static void selectByIdUseConstructor() throws IOException {
        try (SqlSession sqlSession = SqlSessionFactoryBuilderDemo.getSqlSessionFactory().openSession()) {
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            Person person = personMapper.selectByIdUseConstructor(6L);
            System.out.println("result is " + person);
        }
    }

    public static void selectByIdUseAssociation() throws IOException {
        try (SqlSession sqlSession = SqlSessionFactoryBuilderDemo.getSqlSessionFactory().openSession()) {
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            Person person = personMapper.selectByIdUseAssociation(6L);
            System.out.println("result is " + person);
        }
    }

    public static void selectByIdUseAssociationInnerResultMap() throws IOException {
        try (SqlSession sqlSession = SqlSessionFactoryBuilderDemo.getSqlSessionFactory().openSession()) {
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            Person person = personMapper.selectByIdUseAssociationInnerResultMap(6L);
            System.out.println("result is " + person);
        }
    }

    public static void selectPersonWithLogList() throws IOException {
        try (SqlSession sqlSession = SqlSessionFactoryBuilderDemo.getSqlSessionFactory().openSession()) {
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            PersonDto personDto = personMapper.selectPersonWithLogList(6L);
            System.out.println("result is " + personDto);
        }
    }

    public static void selectPersonWithLogListUseInnerJoin() throws IOException {
        try (SqlSession sqlSession = SqlSessionFactoryBuilderDemo.getSqlSessionFactory().openSession()) {
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            PersonDto personDto = personMapper.selectPersonWithLogListUseInnerJoin(6L);
            System.out.println("result is " + personDto);
        }
    }

    public static void selectUseDiscriminator() throws IOException {
        try (SqlSession sqlSession = SqlSessionFactoryBuilderDemo.getSqlSessionFactory().openSession()) {
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            Object discriminatorDto = personMapper.selectUseDiscriminator(4L);
            System.out.println("result is " + discriminatorDto);
        }
    }

    public static void selectByCriteriaUseChoose() throws IOException {
        try (SqlSession sqlSession = SqlSessionFactoryBuilderDemo.getSqlSessionFactory().openSession()) {
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            PersonCriteria criteria = new PersonCriteria();
//            criteria.setSex(0);
            //对于 like 可以使用 sql文件中用bind元素实现 参见 selectUseBind
//            criteria.setName("%person%");
            List<Person> list = personMapper.selectByCriteriaUseChoose(criteria);
            System.out.println("result is " + list);
        }
    }

    public static void selectByCriteriaUseWhere() throws IOException {
        try (SqlSession sqlSession = SqlSessionFactoryBuilderDemo.getSqlSessionFactory().openSession()) {
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            PersonCriteria criteria = new PersonCriteria();
            criteria.setSex(0);
            criteria.setName("%person%");
            List<Person> list = personMapper.selectByCriteriaUseWhere(criteria);
            System.out.println("result is " + list);
        }
    }

    public static void selectByCriteriaUseTrimPrefix() throws IOException {
        try (SqlSession sqlSession = SqlSessionFactoryBuilderDemo.getSqlSessionFactory().openSession()) {
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            PersonCriteria criteria = new PersonCriteria();
            criteria.setSex(0);
            criteria.setName("%person%");
            List<Person> list = personMapper.selectByCriteriaUseTrimPrefix(criteria);
            System.out.println("result is " + list);
        }
    }

    public static void updatePersonUseSet() throws IOException {
        try (SqlSession sqlSession = SqlSessionFactoryBuilderDemo.getSqlSessionFactory().openSession()) {
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            Person person = new Person();
            person.setId(1L);
            person.setName("demoName");
            person.setColor(ColorEnum.BLUE);
            person.setSex(2);
            int update = personMapper.updatePersonUseSet(person);
            sqlSession.commit();
            System.out.println("result is " + update);
        }
    }

    public static void updatePersonUseTrimSuffix() throws IOException {
        //使用自动提交事务模式
        try (SqlSession sqlSession = SqlSessionFactoryBuilderDemo.getSqlSessionFactory().openSession(true)) {
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            Person person = new Person();
            person.setId(2L);
            person.setName("white name12121212");
            person.setColor(ColorEnum.WHITE);
            person.setSex(2);
            int update = personMapper.updatePersonUseTrimSuffix(person);
//            sqlSession.commit();
            System.out.println("result is " + update);
        }
    }

    public static void selectByIdListUseForeach() throws IOException {
        try (SqlSession sqlSession = SqlSessionFactoryBuilderDemo.getSqlSessionFactory().openSession()) {
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            List<Long> ids = Lists.newArrayList(1L, 2L, 3L);
            List<Person> list = personMapper.selectByIdListUseForeach(ids);
            System.out.println("result is " + list);
        }
    }

    public static void selectUseBind() throws IOException {
        try (SqlSession sqlSession = SqlSessionFactoryBuilderDemo.getSqlSessionFactory().openSession()) {
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            PersonCriteria criteria = new PersonCriteria();
            criteria.setName("12");
            List<Person> list = personMapper.selectUseBind(criteria);
            System.out.println("result is " + list);
        }
    }

    public static void selectAllUseMap() throws IOException {
        try (SqlSession sqlSession = SqlSessionFactoryBuilderDemo.getSqlSessionFactory().openSession()) {
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            Map<String, Person> map = personMapper.selectAllUseMap();
            System.out.println("result is " + map);
        }
    }

    public static void selectUseRowBounds() throws IOException {
        try (SqlSession sqlSession = SqlSessionFactoryBuilderDemo.getSqlSessionFactory().openSession()) {
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            RowBounds rowBounds = new RowBounds(1,3);
            List<Person> list = personMapper.selectUseRowBounds(rowBounds);
            System.out.println("result is " + list);
        }
    }


}