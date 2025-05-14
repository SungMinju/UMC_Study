package com.example.demo.exception.handler;

import com.example.demo.apiPayload.code.status.BaseErrorCode;
import com.example.demo.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
