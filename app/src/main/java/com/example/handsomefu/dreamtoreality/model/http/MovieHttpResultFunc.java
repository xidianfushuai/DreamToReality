package com.example.handsomefu.dreamtoreality.model.http;

import com.example.handsomefu.dreamtoreality.model.bean.BookHttpResult;
import com.example.handsomefu.dreamtoreality.model.bean.MovieHttpResult;

import rx.functions.Func1;

/**
 * Created by HandsomeFu on 2016/11/18.
 */

public class MovieHttpResultFunc<T> implements Func1<MovieHttpResult<T>, T> {
    @Override
    public T call(MovieHttpResult<T> tMovieHttpResult) {
        T t = tMovieHttpResult.getSubjects();
        return t;
    }
}
