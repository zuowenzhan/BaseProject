package com.yaolaizai.ylzx.baseproject.base;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.yaolaizai.ylzx.baseproject.R;
import com.yaolaizai.ylzx.baseproject.utils.StatusBarCompat;

/**
 * Created by Administrator on 2016/8/29.
 */
public abstract class BaseActivity<V, T extends BasePresenter<V>> extends FragmentActivity {

    private static final String TAG = "BaseActivity";
    public T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();

//        ButterKnife.bind(this);

        presenter = initPresenter();

        //统一  状态栏  和  项目的颜色
        if (Build.VERSION.SDK_INT >= 21) {
            StatusBarCompat.compat(this);
            StatusBarCompat.compat(this, getResources().getColor(R.color.colorPrimary));
        }
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attach((V) this);
    }

    @Override
    protected void onDestroy() {
        presenter.dettach();
        super.onDestroy();
    }
    //初始化布局
    public   abstract  void initView();

    // 实例化presenter
    public abstract T initPresenter();

    //数据初始化
    public   abstract  void initData();

}

