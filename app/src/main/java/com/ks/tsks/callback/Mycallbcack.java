package com.ks.tsks.callback;

import com.ks.tsks.bean.Aa;
import com.ks.tsks.bean.DatasBean;

/**
 * Created by F0519 on 2019/6/23.
 */

public interface Mycallbcack {
    void OnSuccess(Aa Aa);
    void OnFail(String msg);
}
