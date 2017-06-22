package com.yaolaizai.ylzx.baseproject.rx;

import android.content.Context;
import android.widget.Toast;

import com.yaolaizai.ylzx.baseproject.utils.LogUtil;

import java.io.IOException;

import retrofit2.adapter.rxjava.HttpException;

/**
 * Created by ylzx on 2017/6/5.
 */
public class ApiErrorHelper {

    public static String TAG="ApiErrorHelper";

    public static void handleCommonError(Context context, Throwable e) {
        if (e instanceof HttpException) {
            Toast.makeText(context, "服务暂不可用", Toast.LENGTH_SHORT).show();
        } else if (e instanceof IOException) {
            Toast.makeText(context, "连接失败", Toast.LENGTH_SHORT).show();
        } else if (e instanceof ApiException) {
            //ApiException处理
            ApiException apiException= (ApiException) e;

            if (ApiErrorCode.Logcode2==apiException.getErrorCode()){

                LogUtil.e(TAG,"账号不存在");

                Toast.makeText(context, "账号不存在", Toast.LENGTH_SHORT).show();

            }else if(ApiErrorCode.Logcode==apiException.getErrorCode()){
                LogUtil.e(TAG,"账号出现异常");
            }else if(ApiErrorCode.Logcode1==apiException.getErrorCode()){
                LogUtil.e(TAG,"账号在其他地方登录");
            }
        } else {
            Toast.makeText(context, "未知错误", Toast.LENGTH_SHORT).show();
        }
    }
}
