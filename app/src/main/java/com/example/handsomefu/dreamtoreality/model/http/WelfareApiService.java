package com.example.handsomefu.dreamtoreality.model.http;

import com.example.handsomefu.dreamtoreality.model.bean.Daily;
import com.example.handsomefu.dreamtoreality.model.bean.DataItem;
import com.example.handsomefu.dreamtoreality.model.bean.WelfareHttpResult;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by HandsomeFu on 2016/11/15.
 */

public interface WelfareApiService {
    //其他数据  Android iOS 前端 福利 等
    @GET("data/{type}/{number}/{page}")
    rx.Observable<WelfareHttpResult<List<DataItem>>> getData(@Path("type") String type,
                                                             @Path("number") int number,
                                                             @Path("page") int page);
    //每日精选
    @GET("day/{year}/{month}/{day}")
    rx.Observable<WelfareHttpResult<Daily>> getDaily(@Path("year") int year,
                                                     @Path("month") int month,
                                                     @Path("day") int day);
    //随机数据
    @GET("random/data/{type}/{number}")
    rx.Observable<DataItem> getRandom(@Path("type") String type,
                                  @Path("number") int number);
    //发过干货的日期
    @GET("day/history")
    rx.Observable<List<String>> getHistory();

    //搜索 API

    //获取某几日干货网站数据

    //获取特定日期网站数据

}
