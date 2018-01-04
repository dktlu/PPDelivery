package com.hncs.dktlh.ppdelivery.ui.activity.main.order;

import android.view.View;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseActivity;

import butterknife.BindView;
import cn.share.jack.cygwidget.titlebar.TitleBarUIComponent;

public class CertificationActivity extends BaseActivity {

    @BindView(R.id.titlebar)
    TitleBarUIComponent titlebar;

    @Override
    protected int layoutRes() {
        return R.layout.activity_certification;
    }

    @Override
    protected void initView() {

        titlebar.initTitle(
                getResources().getString(R.string.submit_info),
                getResources().getColor(R.color.login_gray_45));
        titlebar.initLeft(R.mipmap.ic_back_blue, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
