package com.example.handsomefu.dreamtoreality.basemvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;

/**
 * Created by HandsomeFu on 2016/11/16.
 */

public abstract class BaseFragment<V, T extends BasePresenter<V>> extends Fragment {
    public Context mContext;
    public T presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, rootView);
        mContext = getActivity();
        presenter = initPresenter();
        presenter.attach((V) this);
        initView();
        initEvent();
        return rootView;
    }

    @Override
    public void onDestroy() {
        presenter.dettach();
        super.onDestroy();
    }

    protected abstract T initPresenter();

    protected abstract void initEvent();

    protected abstract void initView();

    public abstract int getLayoutId();
}
