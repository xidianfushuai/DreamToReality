package com.example.handsomefu.dreamtoreality.model.http;

import com.example.handsomefu.dreamtoreality.model.bean.Book;
import com.example.handsomefu.dreamtoreality.model.bean.BookHttpResult;
import com.example.handsomefu.dreamtoreality.model.bean.Movie;
import com.example.handsomefu.dreamtoreality.model.bean.MovieHttpResult;
import com.example.handsomefu.dreamtoreality.model.bean.Music;
import com.example.handsomefu.dreamtoreality.model.bean.MusicHttpResult;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by HandsomeFu on 2016/11/17.
 */

public interface DouBApiService {
    //搜索图书
    @GET("book/search")
    Observable<BookHttpResult<List<Book>>> searchBook(
            @Query("q") String q,
            @Query("tag") String tag,
            @Query("start") int start,
            @Query("count") int count);
    //搜索电影
    @GET("movie/search")
    Observable<MovieHttpResult<List<Movie>>> searchMovie(
            @Query("q") String q,
            @Query("tag") String tag,
            @Query("start") int start,
            @Query("count") int count);
    //搜索音乐
    @GET("music/search")
    Observable<MusicHttpResult<List<Music>>> searchMusic(
            @Query("q") String q,
            @Query("tag") String tag,
            @Query("start") int start,
            @Query("count") int count);
}
