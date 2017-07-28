package com.yimeng.dayou.mynewssample;

import android.app.Application;
import android.content.Context;

/**
 * Created by 1 on 2017/4/18.
 */

public class MyApplication extends Application {
    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
