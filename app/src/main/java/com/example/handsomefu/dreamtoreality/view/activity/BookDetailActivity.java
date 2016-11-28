package com.example.handsomefu.dreamtoreality.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.handsomefu.dreamtoreality.R;
import com.example.handsomefu.dreamtoreality.model.bean.Book;
import com.example.handsomefu.dreamtoreality.model.bean.Tag;
import com.example.handsomefu.dreamtoreality.model.utils.Glides;
import com.example.handsomefu.dreamtoreality.presenter.adapter.TagAdapter;
import com.google.gson.Gson;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by HandsomeFu on 2016/11/18.
 */
public class BookDetailActivity extends AppCompatActivity {
    @Bind(R.id.iv_cover)
    ImageView ivCover;
    @Bind(R.id.tv_title)
    TextView tvTitle;

    @Bind(R.id.tv_origin_title)
    TextView tvOriginTitle;
    @Bind(R.id.tv_subtitle)
    TextView tvSub;
    @Bind(R.id.tv_auther)
    TextView tvAuther;
    @Bind(R.id.tv_publish)
    TextView tvPublish;
    @Bind(R.id.tv_rating)
    TextView tvRating;
    @Bind(R.id.rv_tag)
    RecyclerView rvTag;
    @Bind(R.id.tv_summary)
    TextView tvSummary;
    @Bind(R.id.tv_author_intro)
    TextView tvAutherIntro;
    @Bind(R.id.tv_catalog)
    TextView tvCatalog;
    @Bind(R.id.tv_url)
    TextView tvUrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_book_detail);
        ButterKnife.bind(this);
        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        ivCover.measure(w, h);
        int width = ivCover.getMeasuredWidth();
        LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) ivCover.getLayoutParams(); //取控件textView当前的布局参数
        linearParams.height = (int) (width * 3.0);
        ivCover.setLayoutParams(linearParams); //使设置好的布局参数应用到控件
        Book book = new Gson().fromJson(getIntent().getStringExtra("book"), Book.class);
        if (book.getImages() != null && book.getImages().getLarge() != null)
            Glides.getInstance().load(this, book.getImages().getLarge(), ivCover);
        tvTitle.setText(book.getTitle());
        if (!TextUtils.isEmpty(book.getOrigin_title())) {
            tvOriginTitle.setVisibility(View.VISIBLE);
            tvOriginTitle.setText(book.getOrigin_title());
        }
        if (!TextUtils.isEmpty(book.getSubtitle())) {
            tvSub.setVisibility(View.VISIBLE);
            tvSub.setText(book.getSubtitle());
        }
        List<String> namesList = book.getAuthor();
        if (namesList != null && namesList.size() > 0) {
            String names = namesList.get(0);
            for (int i = 1; i < namesList.size(); i++) {
                names = names + "/" + namesList.get(i);
            }
            tvAuther.setVisibility(View.VISIBLE);
            tvAuther.setText(names);
        }
        String pub = book.getPubdate();
        if (!TextUtils.isEmpty(pub)) {
            if (!TextUtils.isEmpty(book.getPublisher()))
                pub = pub + "/" + book.getPublisher();
        }else {
            if (!TextUtils.isEmpty(book.getPublisher()))
                pub = pub + book.getPublisher();
        }
        if (!TextUtils.isEmpty(pub)){
            tvPublish.setVisibility(View.VISIBLE);
            tvPublish.setText(pub);
        }
        if (book.getBRating() != null) {
            tvRating.setVisibility(View.VISIBLE);
            tvRating.setText(book.getBRating().getAverage() + "");
        }
        List<Tag> tagList = book.getTags();
        if (tagList != null && tagList.size() > 0) {
            rvTag.setVisibility(View.VISIBLE);
            rvTag.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
            rvTag.setAdapter(new TagAdapter(this, tagList));
        }
        if (!TextUtils.isEmpty(book.getSummary())) {
            tvSummary.setVisibility(View.VISIBLE);
            tvSummary.setText("    " + book.getSummary());
        }
        if (!TextUtils.isEmpty(book.getAuthor_intro())) {
            tvAutherIntro.setVisibility(View.VISIBLE);
            tvAutherIntro.setText("    " + book.getAuthor_intro());
        }
        if (!TextUtils.isEmpty(book.getCatalog())) {
            tvCatalog.setVisibility(View.VISIBLE);
            tvCatalog.setText("    " + book.getCatalog());
        }if (!TextUtils.isEmpty(book.getUrl())) {
            tvUrl.setVisibility(View.VISIBLE);
            tvUrl.setText("    " + book.getUrl());
        }
    }
}
