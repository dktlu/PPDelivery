package com.hncs.dktlh.ppdelivery.ui.activity.personal.courier;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseActivity;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.courier.adapter.Section2Adapter;

import butterknife.BindView;
import butterknife.OnClick;
import cn.share.jack.cygwidget.titlebar.TitleBarUIComponent;

/**
 * 申请成为自由快递人界面
 */
public class ApplyCourierActivity extends BaseActivity {

    @BindView(R.id.titlebar)
    TitleBarUIComponent mBarUIComponent;

    @BindView(R.id.rl_section1)
    RelativeLayout rlSection1;
    @BindView(R.id.rl_section2)
    RelativeLayout rlSection2;
    @BindView(R.id.rl_section3)
    RelativeLayout rlSection3;
    @BindView(R.id.tv_section1)
    TextView tvSection1;
    @BindView(R.id.tv_section2)
    TextView tvSection2;
    @BindView(R.id.tv_section3)
    TextView tvSection3;
    @BindView(R.id.tv_section1_title)
    TextView tvSection1Title;
    @BindView(R.id.tv_section2_title)
    TextView tvSection2Title;
    @BindView(R.id.tv_section3_title)
    TextView tvSection3Title;
    @BindView(R.id.tv_section1_status)
    TextView tvSection1Status;
    @BindView(R.id.tv_section2_status)
    TextView tvSection2Status;
    @BindView(R.id.tv_section3_status)
    TextView tvSection3Status;

    @Override
    protected int layoutRes() {
        return R.layout.activity_apply_courier;
    }

    @Override
    protected void initView() {
        mBarUIComponent.initTitle(getResources().getString(R.string.apply_courier),
                getResources().getColor(R.color.login_gray_45));
        mBarUIComponent.initLeft(R.mipmap.ic_back_blue, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        setSectionStyle(1, true);
        setSectionStyle(2, false);
        setSectionStyle(3, false);
    }

    @OnClick({R.id.rl_section1, R.id.rl_section2, R.id.rl_section3})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_section2:
                startActivity(new Intent(this, Section2Activity.class));
                break;
        }
    }

    /**
     * 设置回合样式
     * @param tag
     * @param selected
     */
    private void setSectionStyle(int tag, boolean selected) {
        switch (tag) {
            case 1:
                rlSection1.setSelected(selected);
                tvSection1.setSelected(selected);
                tvSection1Title.setSelected(selected);
                tvSection1Status.setSelected(selected);
                break;
            case 2:
                rlSection2.setSelected(selected);
                tvSection2.setSelected(selected);
                tvSection2Title.setSelected(selected);
                tvSection2Status.setSelected(selected);
                break;
            case 3:
                rlSection3.setSelected(selected);
                tvSection3.setSelected(selected);
                tvSection3Title.setSelected(selected);
                tvSection3Status.setSelected(selected);
                break;
        }
    }
}
