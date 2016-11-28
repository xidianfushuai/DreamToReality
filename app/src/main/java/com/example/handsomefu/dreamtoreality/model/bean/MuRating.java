package com.example.handsomefu.dreamtoreality.model.bean;

/**
 * Created by HandsomeFu on 2016/11/23.
 */
public class MuRating {
    private int max;

    public int getMax() {
        return max;
    }

    public double getAverage() {
        return average;
    }

    public int getNumRaters() {
        return numRaters;
    }

    public int getMin() {
        return min;
    }

    private double average;
    private int numRaters;
    private int min;
}
