package com.zhisheng.community;

import com.zhisheng.community.dao.DiscussPostMapper;
import com.zhisheng.community.dao.UserMapper;
import com.zhisheng.community.entity.DiscussPost;
import com.zhisheng.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(101);
        System.out.println(user);
        user = userMapper.selectByName("liubei");
        System.out.println(user);
        user = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }
    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("2202000@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());
        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }
    @Test
    public void testSelectPosts(){
        List<DiscussPost> li = discussPostMapper.selectDiscussPosts(0,10,20);
        for(DiscussPost post:li) {
            System.out.println(post);
        }
        int count = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(count);

    }
}
