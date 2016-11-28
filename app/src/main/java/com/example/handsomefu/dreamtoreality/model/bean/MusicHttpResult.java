package com.example.handsomefu.dreamtoreality.model.bean;

/**
 * Created by HandsomeFu on 2016/11/23.
 */
public class MusicHttpResult<T> {
    private int count;
    private int start;
    private int total;
    private T musics;
    public T getResult() {
        return musics;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
