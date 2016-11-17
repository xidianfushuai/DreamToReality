package com.example.handsomefu.dreamtoreality.view.viewi;

import com.example.handsomefu.dreamtoreality.basemvp.BaseView;
import com.example.handsomefu.dreamtoreality.model.bean.Daily;
import com.example.handsomefu.dreamtoreality.model.bean.DataItem;

import java.util.List;

/**
 * Created by HandsomeFu on 2016/11/16.
 */

public interface HomeView extends BaseView{
    void onDataSuccessed(List<DataItem> dataItemList);
    void onDataFailed(String message);
    void onDailySuccessed(Daily daily);
    void onDailyFailed(String message);
}
