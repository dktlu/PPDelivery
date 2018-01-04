package com.hncs.dktlh.ppdelivery.ui.activity.personal.balance;

import android.view.View;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseActivity;

import butterknife.BindView;
import cn.share.jack.cygwidget.titlebar.TitleBarUIComponent;

public class WithdrawalsActivity extends BaseActivity {

    @BindView(R.id.titlebar)
    TitleBarUIComponent mBarUIComponent;

    @Override
    protected int layoutRes() {
        return R.layout.activity_withdrawals;
    }

    @Override
    protected void initView() {
        mBarUIComponent.initTitle(getResources().getString(R.string.withdrawals),
                getResources().getColor(R.color.login_gray_45));
        mBarUIComponent.initLeft(R.mipmap.ic_back_blue, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
