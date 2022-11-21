package com.example.ipd_team_klean.Error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
public enum ErrorCode {
    BadPasswordException(400,"BadParameterException","잘못된 password 입니다"),
    BadParameterException(400,"BadParameterException","잘못된 형식의 데이터 입니다."),
    UnauthorizedException(401,"UnauthorizedException","허용되지 않는 접근입니다."),
    NotFoundUserException(404,"NotFoundException","계정이 존재하지 않습니다"),
    DuplicatedEmilException(409,"DuplicatedParameterException","이미 존재하는 이메일입니다."),
    DuplicatedSewerException(409,"DuplicatedParameterException","해당 하수구는 존재합니다."),
    INTER_SERVER_ERROR(500,"COMMON-ERR-500","INTER SERVER ERROR"),
    ;

    private int status;
    private String errorCode;
    @Setter
    private String message;


}
