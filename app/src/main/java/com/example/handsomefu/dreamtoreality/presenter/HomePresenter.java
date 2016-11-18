package com.example.handsomefu.dreamtoreality.presenter;

import android.content.Context;

import com.example.handsomefu.dreamtoreality.basemvp.BasePresenter;
import com.example.handsomefu.dreamtoreality.model.bean.Daily;
import com.example.handsomefu.dreamtoreality.model.bean.DataItem;
import com.example.handsomefu.dreamtoreality.model.http.WelfareHttpMethods;
import com.example.handsomefu.dreamtoreality.view.viewi.HomeView;

import java.util.List;

import rx.Subscriber;

/**
 * Created by HandsomeFu on 2016/11/16.
 */

public class HomePresenter extends BasePresenter<HomeView> {
    private Subscriber dataSubscriber;
    private Subscriber dailySubscriber;
    //获取数据
    public void getData(String type, int number, int page) {
        mView.showLoading();

        dataSubscriber = new Subscriber<List<DataItem>>() {
            @Override
            public void onCompleted() {
                mView.hideLoading();
            }

            @Override
            public void onError(Throwable e) {
                mView.hideLoading();
                mView.onDataFailed(e.toString());
            }

            @Override
            public void onNext(List<DataItem> data) {
                mView.onDataSuccessed(data);
            }
        };
        WelfareHttpMethods.getInstance().getDatas(dataSubscriber, type, number, page);
    }
    //获取每日精彩
    public void getDaily(int year, int month, int day) {
        mView.showLoading();
        dailySubscriber = new Subscriber<Daily>() {
            @Override
            public void onCompleted() {
                mView.hideLoading();
            }

            @Override
            public void onError(Throwable e) {
                mView.hideLoading();
                mView.onDailyFailed(e.getMessage());
            }

            @Override
            public void onNext(Daily daily) {
                mView.hideLoading();
                mView.onDailySuccessed(daily);
            }
        };
        WelfareHttpMethods.getInstance().getDaily(dailySubscriber, year, month, day);
    }

    public void destroy() {
        if (dataSubscriber != null && !dataSubscriber.isUnsubscribed()) {
            dataSubscriber.unsubscribe();
        }
        if (dailySubscriber != null && !dailySubscriber.isUnsubscribed()) {
            dailySubscriber.unsubscribe();
        }
    }
}
