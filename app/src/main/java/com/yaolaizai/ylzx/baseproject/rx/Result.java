package com.yaolaizai.ylzx.baseproject.rx;

import java.io.Serializable;

/**
 * Created by ylzx on 2017/6/5.
 */
public class Result<T> implements Serializable{
    private int errorCode;
    private String errorMsg;
    private boolean flag;
    private T data;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", flag=" + flag +
                ", data=" + data +
                '}';
    }
}
