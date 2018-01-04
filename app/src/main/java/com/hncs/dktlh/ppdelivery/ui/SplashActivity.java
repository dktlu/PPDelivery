package com.hncs.dktlh.ppdelivery.ui;

import android.content.Intent;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseActivity;
import com.hncs.dktlh.ppdelivery.ui.activity.login.LoginActivity;

/**
 * 启动页
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected int layoutRes() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {

//        if (UserDao.getInstance().isHaveUser()) {
        startActivity(new Intent(this, LoginActivity.class));
//        } else {
//        startActivity(new Intent(this, LoginActivity.class));
//        }
        finish();
    }
}
