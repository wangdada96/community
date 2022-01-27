package com.zhisheng.community.dao;

import org.springframework.stereotype.Repository;

@Repository("alphahibenate")
public class AlphaHibenateDaoImp implements AlphaDao{
    @Override
    public String select() {
        return "hibenate";
    }
}
