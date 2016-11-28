package com.example.handsomefu.dreamtoreality.view.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.handsomefu.dreamtoreality.R;
import com.example.handsomefu.dreamtoreality.basemvp.BaseFragment;
import com.example.handsomefu.dreamtoreality.model.bean.Daily;
import com.example.handsomefu.dreamtoreality.model.bean.DataItem;
import com.example.handsomefu.dreamtoreality.model.http.ApiType;
import com.example.handsomefu.dreamtoreality.model.utils.CommonUtils;
import com.example.handsomefu.dreamtoreality.presenter.HomePresenter;
import com.example.handsomefu.dreamtoreality.presenter.adapter.HomeAdapter;
import com.example.handsomefu.dreamtoreality.view.activity.WelfareWebviewActivity;
import com.example.handsomefu.dreamtoreality.view.viewi.HomeView;

import java.util.List;

import butterknife.Bind;

/**
 * Created by HandsomeFu on 2016/11/14.
 */
public class HomeFragment extends BaseFragment<HomeView, HomePresenter> implements HomeView, SwipeRefreshLayout.OnRefreshListener {
    @Bind(R.id.rv_list)
    RecyclerView rvList;
    @Bind(R.id.srl_refresh)
    SwipeRefreshLayout srlRefresh;
    private ProgressDialog progressDialog;
    private boolean isWeldare = false;
    //记录上次加载的类型
    private String type;

    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initEvent() {
        srlRefresh.setOnRefreshListener(this);
        srlRefresh.setColorSchemeResources(R.color.colorAccent, R.color.colorGrey, R.color.colorPrimary);
    }

    @Override
    protected void initView() {
        progressDialog = new ProgressDialog(mContext);
        progressDialog.setCancelable(false);
        rvList.setLayoutManager(new LinearLayoutManager(mContext));
//        presenter.getDaily(
//                CommonUtils.getYear(),
//                CommonUtils.getMonth(),
//                CommonUtils.getDay());
    }

    public void getData(String type) {
        this.type = type;
        if (type.equals(ApiType.WELFARE))
            isWeldare = true;
        else
            isWeldare = false;
        presenter.getData(type, 10, 1);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fg_home;
    }

    @Override
    public void showLoading() {
//        progressDialog.show();
        srlRefresh.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
//        progressDialog.dismiss();
        srlRefresh.setRefreshing(false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }

    @Override
    public void onDataSuccessed(List<DataItem> dataItemList) {
        srlRefresh.setRefreshing(false);
        //判断返回的数据是不是福利
        if (!isWeldare) {
            rvList.setLayoutManager(new LinearLayoutManager(mContext));
            rvList.setAdapter(setOnItemClickListener(
                    new HomeAdapter(mContext, dataItemList, false),
                    dataItemList));
        } else {
            //如果是福利  使用流式布局
            rvList.setLayoutManager(new LinearLayoutManager(mContext));
            rvList.setAdapter(setOnItemClickListener(
                    new HomeAdapter(mContext, dataItemList, true),
                    dataItemList));
        }
    }

    @Override
    public void onDataFailed(String message) {
        Log.i("tag" + "onFailed", message);
        CommonUtils.toast(message);
    }

    @Override
    public void onDailySuccessed(Daily daily) {
        srlRefresh.setRefreshing(false);
        rvList.setLayoutManager(new LinearLayoutManager(mContext));
        rvList.setAdapter(setOnItemClickListener(
                new HomeAdapter(mContext, daily.getDataList(), false),
                daily.getDataList()));
    }

    @Override
    public void onDailyFailed(String message) {
        Log.i("tag" + "onFailed", message);
        CommonUtils.toast(message);
    }

    public void getDaily() {
        type = ApiType.DAILY;
        presenter.getDaily(
                CommonUtils.getYear(),
                CommonUtils.getMonth(),
                CommonUtils.getDay());
        isWeldare = false;
    }

    public HomeAdapter setOnItemClickListener(
            HomeAdapter homeAdapter,
            final List<DataItem> dataItemList) {
        homeAdapter.setOnItemClickLitener(new HomeAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), WelfareWebviewActivity.class);
                intent.putExtra("url", dataItemList.get(position).getUrl());
                intent.putExtra("isWelfare", isWeldare);
                startActivity(intent);
            }
        });
        return homeAdapter;
    }

    @Override
    public void onRefresh() {
        if (type.equals(ApiType.DAILY))
            getDaily();
        else
            getData(type);
    }
}
