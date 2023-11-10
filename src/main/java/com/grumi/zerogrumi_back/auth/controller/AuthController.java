package com.grumi.zerogrumi_back.auth.controller;

import com.grumi.zerogrumi_back.auth.dto.UserDTO;
import com.grumi.zerogrumi_back.auth.service.AuthService;
import com.grumi.zerogrumi_back.config.response.BaseResponse;
import com.grumi.zerogrumi_back.config.response.BaseResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/test")
    public String test(){
        return "test success.";
    }

    //회원가입
    @PostMapping("/register")
    public UserDTO register(@ModelAttribute UserDTO userDTO) {

        if (checkDuplicatedId(userDTO.getUserId())){
            UserDTO newUser = authService.addUser(userDTO);
            return newUser;
        }
        return null;
    }

    //중복아이디 검사 (ajax)
    @PostMapping("/checkDuplicatedId")
    public boolean checkDuplicatedId(@RequestParam("userId") String userId){
        return authService.checkDuplicatedId(userId);
    }

    //로그인
    @PostMapping("/login")
    public BaseResponse<Map> login (@ModelAttribute UserDTO userDTO){
        String userId = userDTO.getUserId();

        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);

        if (authService.login(userDTO)){
            return new BaseResponse<>(BaseResponseStatus.LOGIN_SUCCESS, map);
        }
        else{
            return new BaseResponse<>(BaseResponseStatus.LOGIN_INCORRECT);
        }

    }
}
