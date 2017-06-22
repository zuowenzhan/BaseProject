package com.yaolaizai.ylzx.baseproject.http;

import com.yaolaizai.ylzx.baseproject.model.LoginData;
import com.yaolaizai.ylzx.baseproject.rx.Result;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by WuXiaolong on 2016/3/24.
 * github:https://github.com/WuXiaolong/
 * 微信公众号：吴小龙同学
 * 个人博客：http://wuxiaolong.me/
 */
public interface ApiStores {


    @FormUrlEncoded
    @POST("/login/login.do")
    Observable<Result<LoginData>> login(@FieldMap Map<String, String> map);



}
