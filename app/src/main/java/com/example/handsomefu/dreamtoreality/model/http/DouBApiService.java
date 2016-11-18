package com.example.handsomefu.dreamtoreality.model.http;

import com.example.handsomefu.dreamtoreality.model.bean.Book;
import com.example.handsomefu.dreamtoreality.model.bean.DouBHttpResult;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by HandsomeFu on 2016/11/17.
 */

public interface DouBApiService {
    @GET("book/search")
    Observable<DouBHttpResult<List<Book>>> searchBook(
            @Query("q") String q,
            @Query("tag") String tag,
            @Query("start") int start,
            @Query("count") int count);
}
