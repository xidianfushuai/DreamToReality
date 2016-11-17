package com.example.handsomefu.dreamtoreality.basemvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by HandsomeFu on 2016/11/14.
 */

public abstract class BaseActivity<V,T extends BasePresenter<V>> extends AppCompatActivity {
    public T presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        presenter = initPresenter();
//        presenter.attach((V)this);
        initView();
        initEvents();
    }

    @Override
    protected void onDestroy() {
  //      presenter.dettach();
        super.onDestroy();
    }


    protected abstract T initPresenter();

    protected abstract void initView();

    protected abstract void initEvents();

    public abstract int getLayoutId();
}
