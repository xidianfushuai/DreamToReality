package com.example.handsomefu.dreamtoreality.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.example.handsomefu.dreamtoreality.R;

/**
 * Created by HandsomeFu on 2016/11/18.
 */

public class TypeTextView extends TextView {
    private String[] descs = new String[]{"图书", "电影", "音乐"};
    private int[] colors = new int[]{R.color.colorAccent, R.color.colorPrimary, R.color.colorGreen};
    private int currentItem = 0;
    private TypeTextView mTypeTextView;
    public TypeTextView(Context context) {
        super(context);
        initView();
        initOnClick();
    }
    public TypeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
        initOnClick();
    }

    private void initView() {
        mTypeTextView = this;
        mTypeTextView.setText(descs[0]);
        mTypeTextView.setTextColor(getResources().getColor(colors[0]));
    }

    private void initOnClick() {
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                currentItem = ++currentItem % 3;
                mTypeTextView.setText(descs[currentItem]);
                mTypeTextView.setTextColor(getResources().getColor(colors[currentItem]));
            }
        });
    }
}
