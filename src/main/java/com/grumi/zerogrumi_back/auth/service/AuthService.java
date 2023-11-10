package com.grumi.zerogrumi_back.auth.service;

import com.grumi.zerogrumi_back.auth.dto.UserDTO;

public interface AuthService {
    public UserDTO addUser(UserDTO userDTO);

    public boolean checkDuplicatedId(String userId);

    public boolean login(UserDTO userDTO);
}
