package com.hncs.dktlh.ppdelivery.ui.activity.main;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseFragment;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.PersonalCenterActivity;

import butterknife.BindView;
import butterknife.OnClick;
import cn.share.jack.cygwidget.titlebar.TitleBarUIComponent;

/**
 * 个人中心界面
 */
public class ThreeFragment extends BaseFragment {


    @BindView(R.id.personal_titlebar)
    TitleBarUIComponent mTitleBarUIComponent;
    @BindView(R.id.btn_personal)
    Button btnPersonal;

    @Override
    protected int layoutRes() {
        return R.layout.fragment_three;
    }

    @Override
    protected void onViewReallyCreated(View view) {
        mTitleBarUIComponent.initTitle("个人中心");
        mTitleBarUIComponent.setBackgroundResource(R.color.colorPrimary);
    }

    @OnClick(R.id.btn_personal)
    public void onClicked(View view) {
        startActivity(new Intent(getActivity(), PersonalCenterActivity.class));
    }
}
