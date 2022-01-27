package com.zhisheng.community.dao;

import com.zhisheng.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    //userId用来实现查询我的帖子，offset和limit是mysql实现分页查询所用的参数
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);
    //@Param注解用于给参数取别名
    //如果只有一个参数并且在<if>里使用，则必须加上
    int selectDiscussPostRows(@Param("userId") int userId);
}
