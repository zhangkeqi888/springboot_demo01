package cn.com.zkq.springboot.service.impl;

import cn.com.zkq.springboot.entity.User;
import cn.com.zkq.springboot.mapper.UserMapper;
import cn.com.zkq.springboot.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = false)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAllUser() throws Exception {
        return userMapper.selAllUser();
    }

    //分页查询用户数据
    @Override
    public Map<String, Object> findPageUser(Integer page,Integer limit) throws Exception {
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(page,limit);
        PageInfo<User> pageInfo = new PageInfo<User>(userMapper.selAllUser());
        map.put("data",pageInfo.getList());
        map.put("count",pageInfo.getTotal());
        return map;
    }
}
