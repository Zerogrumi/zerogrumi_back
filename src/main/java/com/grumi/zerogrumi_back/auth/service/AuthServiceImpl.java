package com.grumi.zerogrumi_back.auth.service;

import com.grumi.zerogrumi_back.auth.dao.AuthDAO;
import com.grumi.zerogrumi_back.auth.dto.UserDTO;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthDAO authDAO;

    @Override
    public UserDTO addUser(UserDTO userDTO){
        return authDAO.adduser(userDTO);
    }

    @Override
    public boolean checkDuplicatedId(String userId) {
        try {
            if ( authDAO.checkDuplicatedId(userId) == null ) return true;      // 중복이 없을 때 true
            return false;
        } catch (TooManyResultsException exception) {
            return false;                                                      // 중복된 값일 때 false
        }
    }

    @Override
    public boolean login(UserDTO userDTO) {
        UserDTO dto = authDAO.selectLogin(userDTO);
        if ( dto != null ) { // dto 변수 내에 값이 있는 경우, 해당 아이디와 비밀번호를 가진 회원을 데베에서 찾았음 = 로그인 성공
            if (dto.getUserPassword().equals(userDTO.getUserPassword())) {
                System.out.println("login success");
                return true;
            }
        }

        return false;
    }


}
