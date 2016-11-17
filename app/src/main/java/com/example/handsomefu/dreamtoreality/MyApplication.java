package com.example.handsomefu.dreamtoreality;

import android.app.Application;
import android.content.Context;

/**
 * Created by HandsomeFu on 2016/11/14.
 */

public class MyApplication extends Application {
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
    public static Context getContext() {
        return mContext;
    }
}
