package com.example.handsomefu.dreamtoreality.model.http;

import com.example.handsomefu.dreamtoreality.model.bean.Book;
import com.example.handsomefu.dreamtoreality.model.bean.BookHttpResult;
import com.example.handsomefu.dreamtoreality.model.bean.Movie;
import com.example.handsomefu.dreamtoreality.model.bean.Music;

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
 * Created by HandsomeFu on 2016/11/17.
 */

public class DouBHttpMethods {
    public static final String BASE_URL = "https://api.douban.com/v2/";
    private static final int DEFAULT_TIMEOUT = 8;
    private Retrofit retrofit;
    private DouBApiService douBApiService;

    //构造方法私有
    private DouBHttpMethods() {
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
        douBApiService = retrofit.create(DouBApiService.class);
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final DouBHttpMethods INSTANCE = new DouBHttpMethods();
    }

    //获取单例
    public static DouBHttpMethods getInstance() {
        return DouBHttpMethods.SingletonHolder.INSTANCE;
    }



    private <T> void toSubscribe(Observable<T> observable, Subscriber<T> subscriber) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void searchBook(
            Subscriber<List<Book>> subscriber,
            String q,
            String tag,
            int start,
            int count) {
        Observable<List<Book>> observable = douBApiService.
                searchBook(q, tag, start, count).
                map(new BookHttpResultFunc<List<Book>>());
        toSubscribe(observable, subscriber);
    }

    public void searchMovie(
            Subscriber<List<Movie>> subscriber,
            String q,
            String tag,
            int start,
            int count) {
        Observable<List<Movie>> observable = douBApiService.
                searchMovie(q, tag, start, count).
                map(new MovieHttpResultFunc<List<Movie>>());
        toSubscribe(observable, subscriber);
    }
    public void searchMusic(
            Subscriber<List<Music>> subscriber,
            String q,
            String tag,
            int start,
            int count) {
        Observable<List<Music>> observable = douBApiService.
                searchMusic(q, tag, start, count).
                map(new MusicHttpResultFunc<List<Music>>());
        toSubscribe(observable, subscriber);
    }
}
