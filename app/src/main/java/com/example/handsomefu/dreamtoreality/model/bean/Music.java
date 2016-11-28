package com.example.handsomefu.dreamtoreality.model.bean;

import java.util.List;

/**
 * Created by HandsomeFu on 2016/11/23.
 *{"":"七里香","":"https:\/\/music.douban.com\/subject\/1401853\/","":"1401853"}
 */
public class Music {
    private MuRating rating;
    private List<Author> author;
    private String alt_title;
    private String image;
    private List<MusicTag> tags;
    private String mobile_link;
    private Attrs attrs;
    private String title;
    private String alt;
    private String id;

    public MuRating getRating() {
        return rating;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public String getAlt_title() {
        return alt_title;
    }

    public String getImage() {
        return image;
    }

    public List<MusicTag> getTags() {
        return tags;
    }

    public String getMobile_link() {
        return mobile_link;
    }

    public Attrs getAttrs() {
        return attrs;
    }

    public String getTitle() {
        return title;
    }

    public String getAlt() {
        return alt;
    }

    public String getId() {
        return id;
    }
}
