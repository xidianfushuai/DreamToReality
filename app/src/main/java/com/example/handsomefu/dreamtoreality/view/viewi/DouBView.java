package com.example.handsomefu.dreamtoreality.view.viewi;

import com.example.handsomefu.dreamtoreality.basemvp.BaseView;
import com.example.handsomefu.dreamtoreality.model.bean.Book;

import java.util.List;

/**
 * Created by HandsomeFu on 2016/11/17.
 */
public interface DouBView extends BaseView{
    void onSearchBookSuccessed(List<Book> bookList);
    void onSearchBookFailed(String message);
}
