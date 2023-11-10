package com.grumi.zerogrumi_back.auth.dao;

import com.grumi.zerogrumi_back.auth.dto.UserDTO;

public interface AuthDAO {
    public UserDTO adduser(UserDTO userDTO);

    public String checkDuplicatedId(String userId);

    public UserDTO selectLogin(UserDTO userDTO);
}
