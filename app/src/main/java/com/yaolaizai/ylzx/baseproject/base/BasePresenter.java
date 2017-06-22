package com.yaolaizai.ylzx.baseproject.base;

import com.yaolaizai.ylzx.baseproject.http.ApiStores;
import com.yaolaizai.ylzx.baseproject.http.AppClient;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ylzx on 2016/12/21.
 * Presenter基类
 */
public abstract class BasePresenter<T> {

    public T mView;

    protected ApiStores apiStores;
    private CompositeSubscription mCompositeSubscription;

    public void attach(T mView) {
        this.mView = mView;

        apiStores = AppClient.retrofit().create(ApiStores.class);
    }

    public void dettach() {
        mView = null;
        onUnsubscribe();
    }


//    RXjava取消注册，以避免内存泄露
    public void onUnsubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }


    public void addSubscription(Observable observable, Subscriber subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(
                observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }



}
