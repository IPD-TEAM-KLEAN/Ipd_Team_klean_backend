package com.example.ipd_team_klean.Error;

import lombok.Getter;

@Getter
public class CustomException extends  RuntimeException{

    private  ErrorCode errorCode;

    public CustomException(String message,ErrorCode errorCode ) {
        super(message);
        this.errorCode = errorCode;
    }
}
