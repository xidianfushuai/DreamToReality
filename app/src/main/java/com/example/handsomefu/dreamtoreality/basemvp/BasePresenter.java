package com.example.handsomefu.dreamtoreality.basemvp;

/**
 * Created by HandsomeFu on 2016/11/16.
 */

public abstract class BasePresenter<T> {
    public T mView;
    public void attach(T mView) {
        this.mView = mView;
    }
    public void dettach() {
        this.mView = null;
    }
}
