package com.example.handsomefu.dreamtoreality.model.utils;

import android.content.Context;
import android.net.Uri;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.handsomefu.dreamtoreality.R;

/**
 * @author: 蜡笔小新
 * @date: 2016-06-14 16:02
 * @GitHub: https://github.com/meikoz
 */
public class Glides {

    private static Glides instance = new Glides();

    public Glides() {
    }

    public static Glides getInstance() {
        return instance;
    }

    // 加载网络图片
    public void load(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .crossFade()
                .centerCrop()
                .into(imageView);
    }

    // 加载网络图片2
    public void load(Context context, String url, int defaultresid, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .placeholder(defaultresid)
                .error(defaultresid)
                .crossFade()
                .centerCrop()
                .into(imageView);
    }

    // 加载圆型网络图片
    public void loadCircle(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .placeholder(R.color.colorWhite)
                .error(R.color.colorWhite)
                .transform(new GlideCircleTransform(context))
                .crossFade()
                .into(imageView);
    }

    // 加载圆型网络图片
    public void loadCircleHead(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .placeholder(R.color.colorWhite)
                .error(R.color.colorWhite)
                .transform(new GlideCircleTransform(context))
                .crossFade()
                .into(imageView);
    }


    // 加载圆型网络图片
    public void loadCircle(Context context, String url, ImageView imageView, int defaultResId) {
        Glide.with(context)
                .load(url)
                .placeholder(defaultResId)
                .error(defaultResId)
                .transform(new GlideCircleTransform(context))
                .crossFade()
                .into(imageView);
    }

    // 加载圆型网络图片
    public void loadCircle(Context context, Uri url, int placeholder, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .placeholder(placeholder)
                .error(placeholder)
                .transform(new GlideCircleTransform(context))
                .crossFade()
                .into(imageView);
    }


    // 加载本地图片
    public void load(Context context, int resid, ImageView imageView) {
        Glide.with(context)
                .load(resid)
                .placeholder(R.color.colorWhite)
                .error(R.color.colorWhite)
                .crossFade()
                .into(imageView);
    }

    // 加载本地图片
    public void load(Context context, int resid, int defaultresid, ImageView imageView) {
        Glide.with(context)
                .load(resid)
                .placeholder(defaultresid)
                .error(defaultresid)
                .into(imageView);
    }

    // 加载圆型本地图片
    public void loadCircle(Context context, int resId, ImageView imageView) {
        Glide.with(context)
                .load(resId)
//                .placeholder(R.color.abc_white)
//                .error(R.color.colorPrimary)
                .transform(new GlideCircleTransform(context))
//                .crossFade()
                .into(imageView);
    }

    // 加载网络图片动画
    public void loadAnima(Context context, String url, Animation animation, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .placeholder(R.color.colorWhite)
                .error(R.color.colorWhite)
                .animate(animation)
                .crossFade()
                .into(imageView);
    }

    // 加载网络图片动画
    public void loadAnima(Context context, String url, int animationId, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .placeholder(R.color.colorWhite)
                .error(R.color.colorWhite)
                .animate(animationId)
                .crossFade()
                .into(imageView);
    }

    // 加载本地图片动画
    public void loadAnima(Context context, int resId, Animation animation, ImageView imageView) {
        Glide.with(context)
                .load(resId)
                .placeholder(R.color.colorWhite)
                .error(R.color.colorWhite)
                .animate(animation)
                .crossFade()
                .into(imageView);
    }


    // 加载drawable图片
    public void loadAnima(Context context, int resId, int animationId, ImageView imageView) {
        Glide.with(context)
                .load(resId)
                .placeholder(R.color.colorWhite)
                .error(R.color.colorWhite)
                .animate(animationId)
                .crossFade()
                .into(imageView);
    }
}
