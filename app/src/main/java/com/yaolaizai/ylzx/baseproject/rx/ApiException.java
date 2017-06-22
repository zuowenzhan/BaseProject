package com.yaolaizai.ylzx.baseproject.rx;

/**
 * Created by ylzx on 2017/6/5.
 */
public class ApiException extends RuntimeException {

    private int errorCode;
    private boolean flag;

    public ApiException(int code, String errorCode, boolean isflag) {
        super(errorCode);
        this.errorCode = code;
        this.flag = isflag;
    }


    public int getErrorCode() {
        return errorCode;
    }

    public boolean isFlag() {
        return flag;
    }
}
