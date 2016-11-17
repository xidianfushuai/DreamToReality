package com.example.handsomefu.dreamtoreality.model.bean;

import java.util.List;

import static android.R.attr.id;
import static android.R.id.list;

/**
 * Created by HandsomeFu on 2016/11/15.
 *
 * "_id": "58298adf421aa911cf2e1561",
 "createdAt": "2016-11-14T17:58:55.173Z",
 "desc": "A simple spannable string helper",
 "images": [
 "http://img.gank.io/a4e727da-6b91-414a-9f8b-6c0704b0f573"
 ],
 "publishedAt": "2016-11-15T11:26:11.821Z",
 "source": "chrome",
 "type": "Android",
 "url": "https://github.com/jaychang0917/SimpleText",
 "used": true,
 "who": "jp"
  */
public class DataItem {
    private String _id;
    private String createdAt;
    private String desc;
    private List<String> images;
    private String publishedAt;
    private String source;
    private String type;
    private String url;
    private boolean used;
    private String who;


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> imagesList) {
        this.images = imagesList;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    @Override
    public String toString() {
        return "DataItem{" +
                ":id='" + _id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", desc='" + desc + '\'' +
                ", images='" + images + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", source='" + source + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", used='" + used + '\'' +
                ", who=" + who +
                '}';
    }
}
