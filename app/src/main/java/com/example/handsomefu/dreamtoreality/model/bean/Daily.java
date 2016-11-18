package com.example.handsomefu.dreamtoreality.model.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HandsomeFu on 2016/11/16.
 * 每日精彩bean
 */

public class Daily {
    private List<DataItem> Android;
    private List<DataItem> iOS;
    private List<DataItem> 福利;
    private List<DataItem> 休息视频;
    private List<DataItem> 拓展资源;
    private List<DataItem> 前端;

    public List<DataItem> getDataList() {
        List<DataItem> list = new ArrayList<DataItem>();
        if (Android != null)
            list.addAll(Android);
        if (iOS != null)
            Android.addAll(iOS);
        if (福利 != null)
            Android.addAll(福利);
        if (休息视频 != null)
            Android.addAll(休息视频);
        if (拓展资源!= null)
            Android.addAll(拓展资源);
        if (前端 != null)
            Android.addAll(前端);
        return list;
    }
}
