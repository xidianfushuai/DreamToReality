package com.example.handsomefu.dreamtoreality.model.bean;

import android.nfc.Tag;

import java.util.List;
public class Book {
    //评分情况
    private Rating rating;
    //副标题
    private String subtitle;
    //作者们
    private List<String> author;
    //出版日期
    private String pubdate;
    //标签们
    private List<Tag> tags;
    //其他名字 原名
    private String origin_title;
    //图片地址
    private String image;
    //装订样式
    private String binding;
    //翻译人员
    private List<String> translator;
    //目录
    private String catalog;
    //页数
    private String pages;
    //图片
    private Images images;
    //详情页地址
    private String alt;
    //图书id
    private String id;
    //出版商
    private String publisher;
    private String isbn10;
    private String isbn13;
    //书名
    private String title;
    //图书具体信息的url
    private String url;
    //
    private String alt_title;
    //作者简介
    private String author_intro;
    //摘要
    private String summary;
    //价格
    private String price;

    public Rating getRating() {
        return rating;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public List<String> getAuthor() {
        return author;
    }

    public String getPubdate() {
        return pubdate;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public String getOrigin_title() {
        return origin_title;
    }

    public String getImage() {
        return image;
    }

    public String getBinding() {
        return binding;
    }

    public List<String> getTranslator() {
        return translator;
    }

    public String getCatalog() {
        return catalog;
    }

    public String getPages() {
        return pages;
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

    public String getPublisher() {
        return publisher;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getAlt_title() {
        return alt_title;
    }

    public String getAuthor_intro() {
        return author_intro;
    }

    public String getSummary() {
        return summary;
    }

    public String getPrice() {
        return price;
    }
}
