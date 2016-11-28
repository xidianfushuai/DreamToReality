package com.example.handsomefu.dreamtoreality.presenter;

import com.example.handsomefu.dreamtoreality.basemvp.BasePresenter;
import com.example.handsomefu.dreamtoreality.model.bean.Book;
import com.example.handsomefu.dreamtoreality.model.bean.Movie;
import com.example.handsomefu.dreamtoreality.model.bean.Music;
import com.example.handsomefu.dreamtoreality.model.http.DouBHttpMethods;
import com.example.handsomefu.dreamtoreality.view.viewi.SearchView;

import java.util.List;

import rx.Subscriber;

/**
 * Created by HandsomeFu on 2016/11/17.
 */

public class SearchPresenter extends BasePresenter<SearchView> {
    private Subscriber searchBookSubscriber;
    private Subscriber searchMovieSubscriber;
    private Subscriber searchMusicSubscriber;

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

    public void searchMovie(String q, String tag, int start, int count) {
            mView.showLoading();
        searchMovieSubscriber = new Subscriber<List<Movie>>() {
            @Override
            public void onCompleted() {
                mView.hideLoading();
            }

            @Override
            public void onError(Throwable e) {
                mView.hideLoading();
                mView.onSearchMovieFailed(e.getMessage());
            }

            @Override
            public void onNext(List<Movie> movieList) {
                mView.onSearchMovieSuccessed(movieList);
            }
        };
        DouBHttpMethods.getInstance().searchMovie(searchMovieSubscriber, q, tag, start, count);
    }

    public void searchMusic(String q, String tag, int start, int count) {
            mView.showLoading();
        searchMusicSubscriber = new Subscriber<List<Music>>() {
            @Override
            public void onCompleted() {
                mView.hideLoading();
            }

            @Override
            public void onError(Throwable e) {
                mView.hideLoading();
                mView.onSearchMusicFailed(e.getMessage());
            }

            @Override
            public void onNext(List<Music> musicList) {
                mView.onSearchMusicSuccessed(musicList);
            }
        };
        DouBHttpMethods.getInstance().searchMusic(searchMusicSubscriber, q, tag, start, count);
    }

    public void destroy() {
        if (searchBookSubscriber != null && !searchBookSubscriber.isUnsubscribed()) {
            searchBookSubscriber.unsubscribe();
        }
        if (searchMovieSubscriber != null && !searchMovieSubscriber.isUnsubscribed()) {
            searchMovieSubscriber.unsubscribe();
        }
        if (searchMusicSubscriber != null && !searchMusicSubscriber.isUnsubscribed()) {
            searchMusicSubscriber.unsubscribe();
        }
    }
}
