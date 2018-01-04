package com.hncs.dktlh.ppdelivery;

import cn.share.jack.cyghttp.app.CygApplication;
import cn.share.jack.cyghttp.app.HttpServletAddress;

/**
 * Created by dengkaitao on 2017/12/21 16:25.
 * Email：724279138@qq.com
 */

public class App extends CygApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        HttpServletAddress.getInstance().setOfflineAddress("http://192.168.31.250:8080/FriendCircle/");
    }
}
