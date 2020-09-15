package cn.com.zkq.test;

import cn.com.zkq.springboot.MySpringBootApplication;
import cn.com.zkq.springboot.entity.User;
import cn.com.zkq.springboot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.Map;

/**
 *  用户测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringBootApplication.class)
public class UserServiceTest {

    //直接注入业务层对象
    @Autowired
    private UserService userService;

    //测试查询所有用户数据
    @Test
    public void test01(){
        try {
            List<User> users = userService.findAllUser();
            for (User user:users) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //测试分页查询所有用户数据
    @Test
    public void test02(){
        try {
            Map<String, Object> map = userService.findPageUser(1, 3);
            System.out.println("总的数据条数："+map.get("count"));
            List<User> users = (List<User>) map.get("data");
            for (User user:users) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
