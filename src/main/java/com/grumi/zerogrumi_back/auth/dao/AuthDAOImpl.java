package com.grumi.zerogrumi_back.auth.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthDAOImpl implements AuthDAO{

    @Autowired
    private SqlSession sqlSession;
}
