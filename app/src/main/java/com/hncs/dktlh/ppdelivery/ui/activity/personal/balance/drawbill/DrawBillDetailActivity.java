package com.hncs.dktlh.ppdelivery.ui.activity.personal.balance.drawbill;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;
import cn.share.jack.cygwidget.titlebar.TitleBarUIComponent;

public class DrawBillDetailActivity extends BaseActivity {

    @BindView(R.id.titlebar)
    TitleBarUIComponent mBarUIComponent;
    @BindView(R.id.rg_bill_mode)
    RadioGroup rgBillMode;
    @BindView(R.id.rb_company_bill)
    RadioButton rbCompanyBill;
    @BindView(R.id.rb_personal_bill)
    RadioButton rbPersonalBill;
    @BindView(R.id.ll_company)
    LinearLayout llCompany;
    @BindView(R.id.ll_personal)
    LinearLayout llPersonal;

    @Override
    protected int layoutRes() {
        return R.layout.activity_draw_bill_detail;
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

        rgBillMode.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rb_company_bill) {
                    llCompany.setVisibility(View.VISIBLE);
                    llPersonal.setVisibility(View.GONE);
                }
                if (i == R.id.rb_personal_bill) {
                    llCompany.setVisibility(View.GONE);
                    llPersonal.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @OnClick({R.id.tv_submit})
    void onClick(View view) {
        switch (R.id.tv_submit) {
            case R.id.tv_submit:
                startActivity(new Intent(DrawBillDetailActivity.this, DrawBillStatusActivity.class));
                break;
        }
    }
}
