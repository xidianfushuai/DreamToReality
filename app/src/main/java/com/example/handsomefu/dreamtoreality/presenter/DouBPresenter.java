package com.example.handsomefu.dreamtoreality.presenter;

import com.example.handsomefu.dreamtoreality.basemvp.BasePresenter;
import com.example.handsomefu.dreamtoreality.model.bean.Book;
import com.example.handsomefu.dreamtoreality.model.http.DouBHttpMethods;
import com.example.handsomefu.dreamtoreality.view.viewi.DouBView;

import java.util.List;

import rx.Subscriber;

/**
 * Created by HandsomeFu on 2016/11/17.
 */

public class DouBPresenter extends BasePresenter<DouBView> {
    private Subscriber searchBookSubscriber;
    public void searchBook(String q, String tag, int start, int count) {
        mView.showLoading();
        searchBookSubscriber = new Subscriber<List<Book>>() {
            @Override
            public void onCompleted() {
                mView.hideLoading();
            }

            @Override
            public void onError(Throwable e) {
                mView.hideLoading();
                mView.onSearchBookFailed(e.getMessage());
            }

            @Override
            public void onNext(List<Book> bookList) {
                mView.onSearchBookSuccessed(bookList);
            }
        };
        DouBHttpMethods.getInstance().searchBook(searchBookSubscriber, q, tag, start, count);
    }

    public void destroy() {
        if (searchBookSubscriber != null && !searchBookSubscriber.isUnsubscribed()) {
            searchBookSubscriber.unsubscribe();
        }
    }
}
