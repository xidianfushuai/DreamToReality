package com.example.handsomefu.dreamtoreality.model.http;

import com.example.handsomefu.dreamtoreality.model.bean.Daily;
import com.example.handsomefu.dreamtoreality.model.bean.DataItem;
import com.example.handsomefu.dreamtoreality.model.bean.WelfareHttpResult;


import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by HandsomeFu on 2016/11/15.
 */

public class WelfareHttpMethods {
    public static final String BASE_URL = "http://gank.io/api/";
    private static final int DEFAULT_TIMEOUT = 8;
    private Retrofit retrofit;
    private WelfareApiService welfareApiService;
    //构造方法私有
    private WelfareHttpMethods() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.addInterceptor(new HttpLoggingInterceptor().
                setLevel(HttpLoggingInterceptor.Level.BODY)).build();
        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())//使用Gson将返回的Json转换成对象
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        welfareApiService = retrofit.create(WelfareApiService.class);
    }
    //在访问HttpMethods时创建单例
    private static class SingletonHolder{
        private static final WelfareHttpMethods INSTANCE = new WelfareHttpMethods();
    }

    //获取单例
    public static WelfareHttpMethods getInstance(){
        return SingletonHolder.INSTANCE;
    }

    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T> Subscriber真正需要的数据类型，也就是results部分的数据类型
     */
    private class HttpResultFunc<T> implements Func1<WelfareHttpResult<T>, T> {
        @Override
        public T call(WelfareHttpResult<T> welfareHttpResult) {
            if (welfareHttpResult.isError() == true) {
//                throw new ApiException(welfareHttpResult.getError_code());
                throw new ApiException("可能哪里出错了吧~~~");
            }
            return welfareHttpResult.getResult();
        }
    }
    private <T> void toSubscribe(Observable<T> observable, Subscriber<T> subscriber){
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


    public void getDatas(
            Subscriber<List<DataItem>> subscriber,
            String type,
            int number,
            int page){
        Observable<List<DataItem>> observable = welfareApiService.
                getData(type, number, page).
                map(new HttpResultFunc<List<DataItem>>());
        toSubscribe(observable,subscriber);
    }
    public void getDaily(
            Subscriber<Daily> subscriber,
            int year,
            int month,
            int day) {
        Observable<Daily> observable = welfareApiService.
                getDaily(year, month, day).
                map(new HttpResultFunc<Daily>());
        toSubscribe(observable,subscriber);
    }
}
