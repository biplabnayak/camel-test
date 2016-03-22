package com.biplab.camel.test.mybatis;

import com.biplab.camel.test.mybatis.model.User;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @author Biplab Nayak [Created On 3/21/2016].
 */
public interface UserMapper {

    List<User> getAllUsers(RowBounds rowBounds);
}
