package com.ks.task2.persent;


import com.ks.task2.bean.Aa;
import com.ks.task2.callback.Mycallbcack;
import com.ks.task2.model.Mymodel;
import com.ks.task2.view.Myview;

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
