package com.example.ipd_team_klean.Error;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorResponse {
    private  int status;
    private  String message;
    private  String code;

    @Builder

    public ErrorResponse(ErrorCode errorCode) {
        this.status = errorCode.getStatus();
        this.message = errorCode.getMessage();
        this.code = errorCode.getErrorCode();
    }
}
