package com.yaolaizai.ylzx.baseproject.login;

import android.text.TextUtils;

import com.yaolaizai.ylzx.baseproject.base.BasePresenter;
import com.yaolaizai.ylzx.baseproject.model.LoginData;
import com.yaolaizai.ylzx.baseproject.net.MD5Util;
import com.yaolaizai.ylzx.baseproject.rx.BaseSubscriber;
import com.yaolaizai.ylzx.baseproject.rx.HttpUtils;
import com.yaolaizai.ylzx.baseproject.rx.Result;
import com.yaolaizai.ylzx.baseproject.utils.LogUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ylzx on 2016/12/21.
 *
 */
public class LoginPresenter extends BasePresenter<LoginView> {

    public LoginPresenter() {


    }

    public void login() {

        if (TextUtils.isEmpty(mView.getUserName())){
            mView.showFailedError("请输入用户名");
        }else if (TextUtils.isEmpty(mView.getPassword())){
            mView.showFailedError("请输入密码");
        }else {

            HashMap<String, String> sortedParams = new HashMap<String, String>();
            // sysNo 值  3des加密
            sortedParams.put("accountID", mView.getUserName());
            sortedParams.put("pwd", MD5Util.md5(mView.getPassword()));
            Map<String,String> params= HttpUtils.gethttpMap(sortedParams);

            LogUtil.e("tag", mView.getUserName());
            LogUtil.e("tag", mView.getPassword());

            addSubscription(apiStores.login(params), new BaseSubscriber<Result<LoginData>>() {
                @Override
                public void onSuccess(Result<LoginData> result) {

                    LoginData   loginData=result.getData();

                    mView.showFailedError(loginData.getSysno());

                }
                @Override
                public void onError(String errmag) {

                }
            });
                }
    }
    public void toPassWroad() {
        //修改密码界面
        mView.toPassWroad();
    }
}
