package cn.com.zkq.springboot.mapper;

import cn.com.zkq.springboot.entity.User;

import java.util.List;

/**
 *  mapper代理对象
 */
public interface UserMapper {

    //查询所有用户
    List<User> selAllUser() throws Exception;
}
