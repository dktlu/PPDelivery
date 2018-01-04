package com.hncs.dktlh.ppdelivery.ui.activity.personal.insurance;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;
import cn.share.jack.cygwidget.titlebar.TitleBarUIComponent;

public class InsuranceCoverActivity extends BaseActivity {

    @BindView(R.id.titlebar)
    TitleBarUIComponent titlebar;
    @BindView(R.id.tv_insurance_record)
    TextView tvInsuranceRecord;

    @Override
    protected int layoutRes() {
        return R.layout.activity_insurance_cover;
    }

    @Override
    protected void initView() {

        titlebar.initTitle(
                getResources().getString(R.string.insurance_cover),
                getResources().getColor(R.color.login_gray_45));
        titlebar.initLeft(R.mipmap.ic_back_blue, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @OnClick({R.id.tv_compensate_desc, R.id.tv_insurance_record})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_compensate_desc:
                startActivity(new Intent(this, InsuranceServiceActivity.class));
                break;
            case R.id.tv_insurance_record:
                startActivity(new Intent(this, InsuranceRecordActivity.class));
                break;
        }
    }
}
