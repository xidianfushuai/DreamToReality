package com.example.handsomefu.dreamtoreality.model.http;

import com.example.handsomefu.dreamtoreality.model.bean.BookHttpResult;

import rx.functions.Func1;

/**
 * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
 *
 * @param <T> Subscriber真正需要的数据类型，也就是results部分的数据类型
 */
public class BookHttpResultFunc<T> implements Func1<BookHttpResult<T>, T> {
    @Override
    public T call(BookHttpResult<T> bookHttpResult) {
//            if (bookHttpResult.isError() == true) {
//                throw new ApiException(welfareHttpResult.getError_code());
//                throw new ApiException("可能哪里出错了吧~~~");
//            }
        T t = bookHttpResult.getResult();
        return t;
    }
}