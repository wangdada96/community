package com.zhisheng.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class AlphaMybatisDaoImp implements AlphaDao{
    @Override
    public String select() {
        return "mybatis";
    }
}
