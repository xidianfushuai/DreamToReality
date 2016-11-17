package com.example.handsomefu.dreamtoreality.model.utils;

import android.text.TextUtils;
import android.widget.Toast;

import com.example.handsomefu.dreamtoreality.MyApplication;

import java.util.Calendar;

import static android.media.CamcorderProfile.get;

/**
 * Created by HandsomeFu on 2016/11/14.
 */

public class CommonUtils {
    public static void toast(String msg) {
        if (TextUtils.isEmpty(msg))
            return;
        if (msg.length() > 10)
            Toast.makeText(MyApplication.getContext(), msg, Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MyApplication.getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public static int getYear() {
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.YEAR);
    }
    public static int getMonth() {
        Calendar now = Calendar.getInstance();
        int month = now.get(Calendar.MONTH);
        String monthStr = month + "";
        if (monthStr.length() == 1) {
            monthStr = "0" + monthStr;
            month = Integer.parseInt(monthStr);
        }
        return month;
    }
    public static int getDay() {
        Calendar now = Calendar.getInstance();
        int day = now.get(Calendar.DAY_OF_MONTH);
        String dayStr = day + "";
        if (dayStr.length() == 1) {
            dayStr = "0" + dayStr;
            day = Integer.parseInt(dayStr);
        }
        return day;
    }
}
