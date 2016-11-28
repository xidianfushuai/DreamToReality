package com.example.handsomefu.dreamtoreality.model.bean;

import java.util.List;

/**
 * Created by HandsomeFu on 2016/11/23.
 {"":["1. 我的地盘\n2. 七里香\n3. 借口\n4. 外婆\n5. 将军\n6. 搁浅\n7. 乱舞春秋\n8. 困兽之斗\n9. 园游会\n10. 止战之殇"],"":["1"]}
 */
public class Attrs {
    private List<String> publisher;
    private List<String> singer;
    private List<String> version;
    private List<String> pubdate;
    private List<String> title;
    private List<String> media;
    //目录
    private List<String> tracks;

    public List<String> getDiscs() {
        return discs;
    }

    public List<String> getPublisher() {
        return publisher;
    }

    public List<String> getSinger() {
        return singer;
    }

    public List<String> getVersion() {
        return version;
    }

    public List<String> getPubdate() {
        return pubdate;
    }

    public List<String> getTitle() {
        return title;
    }

    public List<String> getMedia() {
        return media;
    }

    public List<String> getTracks() {
        return tracks;
    }

    //碟片数量
    private List<String> discs;

}
