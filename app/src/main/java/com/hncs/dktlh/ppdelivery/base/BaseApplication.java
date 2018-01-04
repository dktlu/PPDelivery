package com.hncs.dktlh.ppdelivery.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by dengkaitao on 2017/12/28 15:17.
 * Email：724279138@qq.com
 */

public class BaseApplication extends Application {
    private  static BaseApplication application;
    //主线程的id
    private static  int mainId;
    //对外提供Handler
    private static Handler handler;
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        mainId = android.os.Process.myTid();
        handler = new Handler();
    }

    //对外获取Context
    public  static Context getAppliction(){
        return application;
    }
    //获取主线程的id
    public static int getMainId() {
        return mainId;
    }
    //获取Handler
    public static Handler getHandler() {
        return handler;
    }
}
