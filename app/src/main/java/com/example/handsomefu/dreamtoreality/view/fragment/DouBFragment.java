package com.example.handsomefu.dreamtoreality.view.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.handsomefu.dreamtoreality.R;
import com.example.handsomefu.dreamtoreality.basemvp.BaseFragment;
import com.example.handsomefu.dreamtoreality.model.bean.Book;
import com.example.handsomefu.dreamtoreality.model.bean.Movie;
import com.example.handsomefu.dreamtoreality.model.bean.Music;
import com.example.handsomefu.dreamtoreality.model.utils.CommonUtils;
import com.example.handsomefu.dreamtoreality.presenter.SearchPresenter;
import com.example.handsomefu.dreamtoreality.presenter.adapter.BookAdapter;
import com.example.handsomefu.dreamtoreality.presenter.adapter.MovieAdapter;
import com.example.handsomefu.dreamtoreality.view.activity.BookDetailActivity;
import com.example.handsomefu.dreamtoreality.view.activity.SearchActivity;
import com.example.handsomefu.dreamtoreality.view.viewi.SearchView;
import com.google.gson.Gson;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by HandsomeFu on 2016/11/14.
 */
public class DouBFragment extends BaseFragment<SearchView, SearchPresenter> implements SearchView {
    private ProgressDialog progressDialog;



    @OnClick({R.id.iv_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_search:
                startActivity(new Intent(getActivity(), SearchActivity.class));
                break;
        }
    }
    @Override
    protected SearchPresenter initPresenter() {
        return new SearchPresenter();
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initView() {
        progressDialog = new ProgressDialog(mContext);
        progressDialog.setCancelable(false);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fg_doub;
    }



    @Override
    public void onSearchBookSuccessed(final List<Book> bookList) {
        BookAdapter bookAdapter = new BookAdapter(mContext, bookList);
        bookAdapter.setOnItemClickLitener(new BookAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), BookDetailActivity.class);
                Gson gson = new Gson();
                intent.putExtra("book", gson.toJson(bookList.get(position)));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSearchBookFailed(String message) {

    }

    @Override
    public void onSearchMovieFailed(String message) {

    }

    @Override
    public void onSearchMovieSuccessed(final List<Movie> movieList) {
        MovieAdapter movieAdapter = new MovieAdapter(mContext, movieList);

    }

    @Override
    public void onSearchMusicFailed(String message) {

    }

    @Override
    public void onSearchMusicSuccessed(List<Music> musicList) {

    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }
}
