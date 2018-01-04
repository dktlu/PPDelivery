package com.hncs.dktlh.ppdelivery.utils;

import com.hncs.dktlh.ppdelivery.base.BaseApplication;

/**
 * Created by dengkaitao on 2017/12/28 15:17.
 * Email：724279138@qq.com
 */

public class UiUtils{
    //定义一个方法 runOnUiThread
    public static void runOnUiThread(Runnable runnable) {
        //根据当前是在主线程还是子线程执行不同的操作
        if(android.os.Process.myTid() == BaseApplication.getMainId()) {
            //在主线程中直接运行即可
            runnable.run();
        }else{
            //说明在子线程中,通过handler的post来执行
            BaseApplication.getHandler().post(runnable);
        }
    }
}
