package com.hncs.dktlh.ppdelivery.ui.activity.personal.balance.drawbill;

import android.view.View;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;
import cn.share.jack.cygwidget.titlebar.TitleBarUIComponent;

public class DrawBillStatusActivity extends BaseActivity {
    @BindView(R.id.titlebar)
    TitleBarUIComponent mBarUIComponent;

    @Override
    protected int layoutRes() {
        return R.layout.activity_draw_bill_status;
    }

    @Override
    protected void initView() {
        mBarUIComponent.initTitle(getResources().getString(R.string.draw_bill),
                getResources().getColor(R.color.login_gray_45));
        mBarUIComponent.initLeft(R.mipmap.ic_back_blue, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @OnClick({R.id.tv_back})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
        }
    }
}
