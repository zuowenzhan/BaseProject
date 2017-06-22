package com.yaolaizai.ylzx.baseproject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.yaolaizai.ylzx.baseproject.http.ApiStores;
import com.yaolaizai.ylzx.baseproject.http.AppClient;
import com.yaolaizai.ylzx.baseproject.model.LoginData;
import com.yaolaizai.ylzx.baseproject.net.MD5Util;
import com.yaolaizai.ylzx.baseproject.rx.BaseSubscriber;
import com.yaolaizai.ylzx.baseproject.rx.HttpUtils;
import com.yaolaizai.ylzx.baseproject.rx.Result;

import java.util.HashMap;
import java.util.Map;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends Activity {


    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
    }

    private void initData() {

            HashMap<String, String> sortedParams = new HashMap<String, String>();
            // sysNo 值  3des加密
            sortedParams.put("accountID", "1302118334");
            sortedParams.put("pwd", MD5Util.md5("123456789"));
            Map<String,String> params= HttpUtils.gethttpMap(sortedParams);

            AppClient.retrofit().create(ApiStores.class)
                    .login(params)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new BaseSubscriber<Result<LoginData>>(){

                        @Override
                        public void onError(String errmag) {

                            Toast.makeText(MainActivity.this, errmag, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onSuccess(Result<LoginData> result) {
                            Log.e(TAG, "---------" + result.getData().getSysno());
                        }

                    });


    }
}
