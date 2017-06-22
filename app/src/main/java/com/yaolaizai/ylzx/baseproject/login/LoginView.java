package com.yaolaizai.ylzx.baseproject.login;

import com.yaolaizai.ylzx.baseproject.base.BaseView;

/**
 * Created by ylzx on 2016/12/20.
 *
 * 接口对应的方法
 */
public interface LoginView extends BaseView {

    String getUserName();
    String getPassword();
    void clearUserName();
    void clearPassword();
    void toMainActivity();
    void showFailedError(String message);
    void toPassWroad();
}
