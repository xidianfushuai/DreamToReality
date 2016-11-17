package com.example.handsomefu.dreamtoreality.model.bean;

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
        Android.addAll(iOS);
        Android.addAll(福利);
        Android.addAll(休息视频);
        Android.addAll(拓展资源);
        Android.addAll(前端);
        return Android;
    }
}
