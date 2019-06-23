package com.ks.tsks.persent;

import com.ks.tsks.bean.Aa;
import com.ks.tsks.callback.Mycallbcack;
import com.ks.tsks.model.Mymodel;
import com.ks.tsks.view.Myview;

/**
 * Created by F0519 on 2019/6/23.
 */

public class Mypersentimpl implements Mypersent, Mycallbcack {
    private Mymodel mymodel;
    private Myview myview;

    public Mypersentimpl(Mymodel mymodel, Myview myview) {
        this.mymodel = mymodel;
        this.myview = myview;
    }

    @Override
    public void getData() {
        if(mymodel!=null){
            mymodel.getData(this);
        }
    }

    @Override
    public void OnSuccess(Aa Aa) {
        if(myview!=null){
            myview.OnSuccess(Aa);
        }
    }

    @Override
    public void OnFail(String msg) {
        if(myview!=null){
            myview.OnFail(msg);
        }
    }
}
