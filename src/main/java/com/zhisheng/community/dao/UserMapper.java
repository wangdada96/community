package com.zhisheng.community.dao;

import com.zhisheng.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper //作用同Repository
public interface UserMapper {
    User selectById(int id);

    User selectByName(String username);

    User selectByEmail(String email);

    int insertUser(User user);

    int updateStatus(int id,int status);

    int updateHeader(int id,String headerUrl);

    int updatePassword(int id,String password);


}
