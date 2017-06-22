package com.yaolaizai.ylzx.baseproject.rx;

/**
 * Created by ylzx on 2017/6/5.
 */
public class ApiErrorCode {

    /** 客户端错误*/
  public static   int ERROR_CLIENT_AUTHORIZED = 1;
    /** 用户授权失败*/
    public static  int ERROR_USER_AUTHORIZED = 2;
    /** 请求参数错误*/
    public static  int ERROR_REQUEST_PARAM = 3;
    /** 参数检验不通过 */
    public static  int ERROR_PARAM_CHECK = 4;
    /** 自定义错误*/
    public static  int ERROR_OTHER = 10;
    /** 无网络连接*/
    public static int ERROR_NO_INTERNET = 11;

    //账号异常
    public static int Logcode=10086;
    //在其他地方登录
    public static int Logcode1=10087;
  //账号不存在
    public static int Logcode2=999999;


}
