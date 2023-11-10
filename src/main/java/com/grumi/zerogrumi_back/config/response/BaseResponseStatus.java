package com.grumi.zerogrumi_back.config.response;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {

    SUCCESS(true, 1000, "요청에 성공하였습니다."),
    REGISTER_SUCCESS(true, 1001, "register success"),
    LOGIN_SUCCESS(true, 1002, "login success"),
    FIND_DATABASE(true, 1004, "유저 데이터베이스가 존재합니다. main창으로 이동해주세요."),
    CHANGED_DATABASE(true, 1005, "유저 데이터베이스의 이름을 성공적으로 변경했습니다"),
    ERROR(false, 2000, "요청값을 확인해주세요"),
    LOGIN_INCORRECT(false, 2001,"아이디 혹은 비밀번호를 다시 확인해주세요."),
    NO_DATABASE(true, 2002, "유저의 데이터베이스가 존재하지 않습니다. welcome으로 이동해 데이터베이스를 생성해주세요."),
    REGISTER_FAILED(false,2003, "회원가입 실패! 중복된 아이디입니다.");

    private final boolean isSuccess;
    private final int code;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, int code, String message){
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }

}
