package com.grumi.zerogrumi_back.auth.service;

import com.grumi.zerogrumi_back.auth.dao.AuthDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthDAO authDAO;
}
