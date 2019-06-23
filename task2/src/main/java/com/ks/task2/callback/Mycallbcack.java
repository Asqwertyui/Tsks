package com.ks.task2.callback;


import com.ks.task2.bean.Aa;

/**
 * Created by F0519 on 2019/6/23.
 */

public interface Mycallbcack {
    void OnSuccess(Aa Aa);
    void OnFail(String msg);
}
