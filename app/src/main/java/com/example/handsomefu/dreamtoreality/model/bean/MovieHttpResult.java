package com.example.handsomefu.dreamtoreality.model.bean;

/**
 * Created by HandsomeFu on 2016/11/18.
 */
public class MovieHttpResult<T> {
    private int count;
    private int start;
    private int total;
    private String title;
    private T subjects;
    public T getSubjects() {
        return subjects;
    }

    public int getCount() {
        return count;
    }

    public int getStart() {
        return start;
    }

    public int getTotal() {
        return total;
    }

    public String getTitle() {
        return title;
    }



}
