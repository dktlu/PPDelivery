package com.hncs.dktlh.ppdelivery.ui.activity.personal.setting;

import android.view.View;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseActivity;

import butterknife.BindView;
import cn.share.jack.cygwidget.titlebar.TitleBarUIComponent;

public class ChangePwdActivity extends BaseActivity {


    @BindView(R.id.titlebar)
    TitleBarUIComponent mBarUIComponent;

    @Override
    protected int layoutRes() {
        return R.layout.activity_change_pwd;
    }

    @Override
    protected void initView() {

        mBarUIComponent.initTitle(getResources().getString(R.string.set_new_pwd),
                getResources().getColor(R.color.login_gray_45));
        mBarUIComponent.setBackgroundColor(getResources().getColor(R.color.white));
        mBarUIComponent.initLeft(R.mipmap.ic_back_blue, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
