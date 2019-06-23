package com.ks.tsks.bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by F0519 on 2019/6/23.
 */

public interface Myservice {
    //http://106.13.63.54:8080/sys/xin195yk/jiekou2.json
    public String url="http://106.13.63.54:8080/sys/xin195yk/";
    @GET("jiekou2.json")
    Observable<Aa> gteAa();

}
