package com.example.handsomefu.dreamtoreality.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.handsomefu.dreamtoreality.R;

/**
 * Created by HandsomeFu on 2016/11/14.
 */
public class FriendsFragment extends android.support.v4.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_friends, container, false);
        return view;
    }
}
