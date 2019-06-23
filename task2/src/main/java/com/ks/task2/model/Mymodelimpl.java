package com.ks.task2.model;

import android.util.Log;

import com.ks.task2.bean.Aa;
import com.ks.task2.bean.Myservice;
import com.ks.task2.callback.Mycallbcack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by F0519 on 2019/6/23.
 */

public class Mymodelimpl implements Mymodel {
    @Override
    public void getData(final Mycallbcack mycallbcack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Myservice.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Myservice myservice = retrofit.create(Myservice.class);
        Observable<Aa> gteAa = myservice.gteAa();

        gteAa.subscribeOn(Schedulers.io())
              . observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Aa>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Aa aa) {
        if(aa!=null){
            mycallbcack.OnSuccess(aa);
        }else {
            mycallbcack.OnFail("no");
        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("tga",e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("tga","onComplete");
                    }
                });
    }
}
