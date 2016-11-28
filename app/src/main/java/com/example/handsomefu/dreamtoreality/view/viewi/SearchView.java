package com.example.handsomefu.dreamtoreality.view.viewi;

import com.example.handsomefu.dreamtoreality.basemvp.BaseView;
import com.example.handsomefu.dreamtoreality.model.bean.Book;
import com.example.handsomefu.dreamtoreality.model.bean.Movie;
import com.example.handsomefu.dreamtoreality.model.bean.Music;

import java.util.List;

/**
 * Created by HandsomeFu on 2016/11/17.
 */
public interface SearchView extends BaseView{
    void onSearchBookSuccessed(List<Book> bookList);
    void onSearchBookFailed(String message);

    void onSearchMovieFailed(String message);

    void onSearchMovieSuccessed(List<Movie> movieList);

    void onSearchMusicFailed(String message);

    void onSearchMusicSuccessed(List<Music> musicList);
}
