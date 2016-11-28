package com.example.handsomefu.dreamtoreality.model.bean;

import java.util.List;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by HandsomeFu on 2016/11/18.
 */

public class Movie {
    //评分
    private MoRaiting rating;
    //类型 流派
    private List<String> genres;
    //电影名字
    private String title;
    //演员阵容
    private List<Cast> casts;
    //
    private int collect_count;
    //原名
    private String original_title;
    //子类型
    private String subtype;
    //导演们
    private List<Director> directors;
    //上映时间
    private String year;
    //剧照
    private Images images;
    private String alt;
    private String id;

    public MoRaiting getRating() {
        return rating;
    }

    public List<String> getGenres() {
        return genres;
    }

    public String getTitle() {
        return title;
    }

    public List<Cast> getCasts() {
        return casts;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getSubtype() {
        return subtype;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public String getYear() {
        return year;
    }

    public Images getImages() {
        return images;
    }

    public String getAlt() {
        return alt;
    }

    public String getId() {
        return id;
    }
}
