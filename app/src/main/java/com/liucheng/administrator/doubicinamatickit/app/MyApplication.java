package com.liucheng.administrator.doubicinamatickit.app;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.liucheng.administrator.doubicinamatickit.util.StringUtil;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;


/**
 * Created by 邹柳钦 on 2017/11/4 0004.
 */

public class MyApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();


    }

    public static Context getContext() {
        return context;
    }
}
