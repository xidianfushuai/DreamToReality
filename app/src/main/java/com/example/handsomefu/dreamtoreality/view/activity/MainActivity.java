package com.example.handsomefu.dreamtoreality.view.activity;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.handsomefu.dreamtoreality.basemvp.BaseActivity;
import com.example.handsomefu.dreamtoreality.model.http.ApiType;
import com.example.handsomefu.dreamtoreality.model.utils.CommonUtils;
import com.example.handsomefu.dreamtoreality.model.utils.Glides;
import com.example.handsomefu.dreamtoreality.presenter.HomePresenter;
import com.example.handsomefu.dreamtoreality.view.dialog.CustomDialog;
import com.example.handsomefu.dreamtoreality.view.fragment.DouBFragment;
import com.example.handsomefu.dreamtoreality.view.fragment.HomeFragment;
import com.example.handsomefu.dreamtoreality.view.fragment.MyFragment;
import com.example.handsomefu.dreamtoreality.R;
import com.example.handsomefu.dreamtoreality.view.viewi.HomeView;

import butterknife.Bind;
import butterknife.OnClick;

import static com.example.handsomefu.dreamtoreality.MyApplication.getContext;

public class MainActivity extends BaseActivity<HomeView, HomePresenter> implements BottomNavigationBar.OnTabSelectedListener {
    @Bind(R.id.bnb_navigation)
    BottomNavigationBar bottomNavigationBar;
    @Bind(R.id.iv_head)
    ImageView ivHead;
    @Bind(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    private FragmentManager mFragmentManager;
    private int currentFragment = 0;

    @Override
    protected HomePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.main_home, "Home").
                setActiveColorResource(R.color.colorPrimary));
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.main_bmm, "BMM").
                setActiveColorResource(R.color.colorPrimary));
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.main_my, "My").
                setActiveColorResource(R.color.colorPrimary));
        bottomNavigationBar.initialise();

        Glides.getInstance().loadCircle(getContext(), R.mipmap.beauty1, ivHead);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mFragmentManager = getSupportFragmentManager();
        setDefaultFragment();
        CustomDialog customDialog = new CustomDialog.Builder(this).
                setColorId(R.color.colorBlack).
                setNegativeDesc("buyong").
                setPositiveDesc("good").
                setTitle("enna").setOnClickListener(new CustomDialog.Builder.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.tv_title:
                        CommonUtils.toast("tv_title");
                        break;
                    case R.id.tv_confirm:
                        CommonUtils.toast("tv_confirm");
                        break;
                    case R.id.tv_cancel:
                        CommonUtils.toast("tv_cancel");
                        break;

                }
            }
        }).create();
        customDialog.show();
    }

    @Override
    protected void initEvents() {
        bottomNavigationBar.setTabSelectedListener(this);
        //实现抽屉图标/返回箭头之间的旋转切换
        final DrawerArrowDrawable indicator = new DrawerArrowDrawable(this);
        indicator.setColor(Color.WHITE);
        getSupportActionBar().setHomeAsUpIndicator(indicator);
        //当DrawerLayout划出来时，非drawerlayout区域的颜色  透明
        drawerLayout.setScrimColor(Color.TRANSPARENT);
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //设置左上角的图标旋转位置与drawerlayout同步
                if (((ViewGroup) drawerView).getChildAt(1).getId() == R.id.sbLeft) {
                    indicator.setProgress(slideOffset);
                }
            }
        });
    }

    @OnClick({R.id.ll_splendid,
            R.id.ll_beautiful_girl,
            R.id.ll_android,
            R.id.ll_ios,
            R.id.ll_web,
            R.id.ll_video,
            R.id.ll_more,
            R.id.ll_app})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_splendid:
                //每日精彩
                requestDaily();
                break;
            case R.id.ll_beautiful_girl:
                requestData(ApiType.WELFARE);
                break;
            case R.id.ll_android:
                requestData(ApiType.ANDROID);
                break;
            case R.id.ll_ios:
                requestData(ApiType.IOS);
                break;
            case R.id.ll_web:
                requestData(ApiType.WEB);
                break;
            case R.id.ll_video:
                requestData(ApiType.VIDEO);
                break;
            case R.id.ll_more:
                requestData(ApiType.MORE);
                break;
            case R.id.ll_app:
                requestData(ApiType.ALL);
                break;

        }
    }

    private void requestDaily() {
        Fragment fragment = mFragmentManager.findFragmentByTag("0");
        if (fragment != null) {
            ((HomeFragment) fragment).getDaily();
        }
    }

    private void requestData(String type) {
        Fragment fragment = mFragmentManager.findFragmentByTag("0");
        if (fragment != null) {
            ((HomeFragment) fragment).getData(type);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.ac_main;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //控制DrawerLayout
        if (item.getItemId() == android.R.id.home) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        }
        return true;
    }

    private void setDefaultFragment() {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fl_mian, new HomeFragment(), "0");
        fragmentTransaction.commit();
    }

    private void switchFragment(int to) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        Fragment hideFragment = mFragmentManager.findFragmentByTag("" + currentFragment);
        if (hideFragment != null) {
            fragmentTransaction.hide(hideFragment);
        }
        Fragment showFragment = mFragmentManager.findFragmentByTag("" + to);
        if (showFragment == null) {
            switch (to) {
                case 1:
                    fragmentTransaction.add(R.id.fl_mian, new DouBFragment(), "1");
                    break;
                case 2:
                    fragmentTransaction.add(R.id.fl_mian, new MyFragment(), "2");
                    break;
            }
        } else {
            fragmentTransaction.show(showFragment);
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onTabSelected(int position) {
        switch (position) {
            case 0:
                switchFragment(0);
                currentFragment = 0;
                break;
            case 1:
                switchFragment(1);
                currentFragment = 1;
                break;
            case 2:
                switchFragment(2);
                currentFragment = 2;
                break;
        }
    }


    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        presenter.destroy();
    }
}
