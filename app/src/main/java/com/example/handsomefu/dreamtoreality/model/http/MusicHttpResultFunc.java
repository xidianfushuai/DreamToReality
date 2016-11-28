package com.example.handsomefu.dreamtoreality.model.http;

import com.example.handsomefu.dreamtoreality.model.bean.Music;
import com.example.handsomefu.dreamtoreality.model.bean.MusicHttpResult;

import java.util.List;

import rx.functions.Func1;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by HandsomeFu on 2016/11/23.
 */
public class MusicHttpResultFunc<T> implements Func1<MusicHttpResult<T>, T>{

    @Override
    public T call(MusicHttpResult<T> tMusicHttpResult) {

        T t = tMusicHttpResult.getResult();
        return t;
    }
}
