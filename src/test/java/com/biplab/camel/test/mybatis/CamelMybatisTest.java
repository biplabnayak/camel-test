package com.biplab.camel.test.mybatis;

import com.biplab.camel.test.mybatis.model.User;
import org.apache.camel.component.mybatis.MyBatisComponent;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import java.util.List;

/**
 * @author Biplab Nayak [Created On 3/21/2016].
 */
public class CamelMybatisTest extends CamelTestSupport {

    @Test
    public void testMybatisPagination() {

        MyBatisComponent myBatisComponent = (MyBatisComponent)context.getComponent("mybatis");

        SqlSessionFactory sqlSessionFactory = myBatisComponent.getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getAllUsers(new RowBounds(0,6));
        System.out.println(userList.size());
        sqlSession.close();
        System.out.println(userList);

    }
}
