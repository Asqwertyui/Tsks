package com.ks.tsks.bean;

import android.app.Application;

/**
 * Created by F0519 on 2019/6/23.
 */

public class App extends Application {
    private static App app;

    public App() {
        app = this;
    }

    public static App getApp() {
        return app;
    }
}
