package com.yaolaizai.ylzx.baseproject.rx;

import android.content.Context;

import com.yaolaizai.ylzx.baseproject.utils.LogUtil;

import java.net.UnknownHostException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by ylzx on 2017/6/5.
 */
public abstract class BaseSubscriber<T> extends Subscriber<T> {

    private Context mContext;

    public BaseSubscriber() {
    }

    public BaseSubscriber(Context context) {
        mContext = context;
    }
    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
//        ApiErrorHelper.handleCommonError(mContext, e);
        if (e instanceof HttpException) {

            HttpException httpException = (HttpException) e;
            //httpException.response().errorBody().string()
            int code = httpException.code();
            String msg = httpException.getMessage();
            LogUtil.e("code", "=====" + code);
            if (code == 504) {
                msg = "网络不给力";
            }
            if (code == 502 || code == 404) {
                msg = "服务器异常，请稍后再试";
            }

            onError(msg);

        } else if (e instanceof UnknownHostException) {

            onError("网络异常");

        } else if (e instanceof ApiException) {
            //ApiException处理
            ApiException apiException= (ApiException) e;
            onError(apiException.getMessage());

//            if (ApiErrorCode.Logcode2==apiException.getErrorCode()){
//                onError("账号不存在");
//            }else if(ApiErrorCode.Logcode==apiException.getErrorCode()){
//                onError("账号出现异常");
//            }else if(ApiErrorCode.Logcode1==apiException.getErrorCode()){
//                onError("账号在其他地方登录");
//            }

        } else{
            onError(e.toString());
        }


    }

    @Override
    public void onNext(T t) {

        if (t == null) {
            onError("result is null");
            return;
        }
        onSuccess(t);

    }

    public abstract void onSuccess(T result);
    public abstract void onError(String errmag);
}

