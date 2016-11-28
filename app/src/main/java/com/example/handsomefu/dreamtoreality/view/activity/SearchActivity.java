package com.example.handsomefu.dreamtoreality.view.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.handsomefu.dreamtoreality.R;
import com.example.handsomefu.dreamtoreality.basemvp.BaseActivity;
import com.example.handsomefu.dreamtoreality.model.bean.Book;
import com.example.handsomefu.dreamtoreality.model.bean.Movie;
import com.example.handsomefu.dreamtoreality.model.bean.Music;
import com.example.handsomefu.dreamtoreality.model.utils.CommonUtils;
import com.example.handsomefu.dreamtoreality.presenter.SearchPresenter;
import com.example.handsomefu.dreamtoreality.presenter.adapter.BookAdapter;
import com.example.handsomefu.dreamtoreality.presenter.adapter.MovieAdapter;
import com.example.handsomefu.dreamtoreality.presenter.adapter.MusicAdapter;
import com.example.handsomefu.dreamtoreality.view.viewi.SearchView;
import com.example.handsomefu.dreamtoreality.view.widget.TypeTextView;
import com.google.gson.Gson;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by HandsomeFu on 2016/11/18.
 */

public class SearchActivity extends BaseActivity<SearchView, SearchPresenter> implements SearchView, SwipeRefreshLayout.OnRefreshListener {
    @Bind(R.id.ttv_type)
    TypeTextView ttvType;
    @Bind(R.id.et_book_name)
    EditText etBookName;
    @Bind(R.id.bt_search)
    Button btSearch;
    @Bind(R.id.rv_dou_b)
    RecyclerView rvDouB;
    @Bind(R.id.srl_refresh)
    SwipeRefreshLayout srlRefesh;
    private ProgressDialog progressDialog;
    //记录刚刚的搜索类型
    String type;

    @Override
    protected SearchPresenter initPresenter() {
        return new SearchPresenter();
    }

    @Override
    protected void initView() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        rvDouB.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initEvents() {
        srlRefesh.setOnRefreshListener(this);
        srlRefesh.setColorSchemeResources(R.color.colorAccent, R.color.colorBlack, R.color.colorGreen);
    }

    @Override
    public int getLayoutId() {
        return R.layout.ac_search;
    }

    @OnClick({R.id.bt_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_search:
                if (TextUtils.isEmpty(getSearchKey())) {
                    CommonUtils.toast("请输入关键字");
                    return;
                }
                type = ttvType.getText().toString();
                switch (type) {
                    case "图书":
                        presenter.searchBook(getSearchKey(), null, 0, 10);
                        break;
                    case "电影":
                        presenter.searchMovie(getSearchKey(), null, 0, 10);
                        break;
                    case "音乐":
                        presenter.searchMusic(getSearchKey(), null, 0, 10);
                        break;
                }

                break;
        }
    }

    private String getSearchKey() {
        return etBookName.getText().toString().trim();
    }

    @Override
    public void onSearchBookSuccessed(final List<Book> bookList) {
        srlRefesh.setRefreshing(false);
        BookAdapter bookAdapter = new BookAdapter(this, bookList);
        bookAdapter.setOnItemClickLitener(new BookAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(SearchActivity.this, BookDetailActivity.class);
                Gson gson = new Gson();
                intent.putExtra("book", gson.toJson(bookList.get(position)));
                startActivity(intent);
            }
        });
        rvDouB.setAdapter(bookAdapter);
    }

    @Override
    public void onSearchBookFailed(String message) {

    }

    @Override
    public void onSearchMovieFailed(String message) {

    }

    @Override
    public void onSearchMovieSuccessed(final List<Movie> movieList) {
        srlRefesh.setRefreshing(false);
        MovieAdapter movieAdapter = new MovieAdapter(this, movieList);
        movieAdapter.setOnItemClickLitener(new MovieAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                String alt = movieList.get(position).getAlt();
                if (TextUtils.isEmpty(alt))
                    return;
                Intent intent = new Intent(SearchActivity.this, DouBWebviewActivity.class);
                intent.putExtra("url", alt);
                startActivity(intent);
            }
        });
        rvDouB.setAdapter(movieAdapter);
    }

    @Override
    public void onSearchMusicFailed(String message) {

    }

    @Override
    public void onSearchMusicSuccessed(final List<Music> musicList) {
        srlRefesh.setRefreshing(false);
        MusicAdapter musicAdapter = new MusicAdapter(this, musicList);
        musicAdapter.setOnItemClickListener(new MusicAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String alt = musicList.get(position).getMobile_link();
                if (TextUtils.isEmpty(alt))
                    return;
                Intent intent = new Intent(SearchActivity.this, DouBWebviewActivity.class);
                intent.putExtra("url", alt);
                startActivity(intent);
            }
        });
        rvDouB.setAdapter(musicAdapter);
    }

    @Override
    public void showLoading() {
        srlRefesh.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        srlRefesh.setRefreshing(false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }

    @Override
    public void onRefresh() {
        switch (type) {
            case "图书":
                presenter.searchBook(getSearchKey(), null, 0, 10);
                break;
            case "电影":
                presenter.searchMovie(getSearchKey(), null, 0, 10);
                break;
            case "音乐":
                presenter.searchMusic(getSearchKey(), null, 0, 10);
                break;
        }
    }
}
