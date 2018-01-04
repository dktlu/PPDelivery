package com.hncs.dktlh.ppdelivery.ui.activity.personal.myinfo;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseActivity;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.MyOneLineView;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.myinfo.sincerity.MySincerityActivity;

import butterknife.BindView;
import cn.share.jack.cygwidget.titlebar.TitleBarUIComponent;

/**
 * 我的资料界面
 */
public class MyInfosActivity extends BaseActivity implements MyOneLineView.OnRootClickListener {

    @BindView(R.id.titlebar)
    TitleBarUIComponent titlebar;
    @BindView(R.id.ll_root)
    LinearLayout llRoot;

    private MyOneLineView levelItem;

    @Override
    protected int layoutRes() {
        return R.layout.activity_my_infos;
    }

    @Override
    protected void initView() {

        titlebar.initTitle(
                getResources().getString(R.string.my_infos),
                getResources().getColor(R.color.login_gray_45));
        titlebar.initLeft(R.mipmap.ic_back_blue, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //更换头像item
        MyOneLineView headItem = new MyOneLineView(this);
        headItem.init(-1, getResources().getString(R.string.my_change_head));
        headItem.showLeftIcon(false);
        headItem.setIvRightIcon(R.mipmap.ic_personal_right_arrow);
        headItem.showDivider(true, true);
        llRoot.addView(headItem);

        //昵称item
        MyOneLineView nickNameItem = new MyOneLineView(this);
        nickNameItem.init(-1, getResources().getString(R.string.my_nickname));
        nickNameItem.showLeftIcon(false);
        nickNameItem.setIvRightIcon(R.mipmap.ic_personal_right_arrow);
        nickNameItem.showDivider(false, true);
        llRoot.addView(nickNameItem);

        //电话号码item
        MyOneLineView phoneItem = new MyOneLineView(this);
        phoneItem.init(-1, getResources().getString(R.string.my_phone));
        phoneItem.showLeftIcon(false);
        phoneItem.setIvRightIcon(R.mipmap.ic_personal_right_arrow);
        phoneItem.showDivider(false, true);
        llRoot.addView(phoneItem);

        View view = new View(this);
        ViewGroup.LayoutParams layoutParams =
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 20);
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(getResources().getColor(R.color.background));
        llRoot.addView(view);

        //诚信等级
        levelItem = new MyOneLineView(this);
        levelItem.init(-1, getResources().getString(R.string.my_sincerity_level));
        levelItem.showLeftIcon(false);
        levelItem.setIvRightIcon(R.mipmap.ic_personal_right_arrow);
        levelItem.showDivider(true, true);
        levelItem.setOnRootClickListener(this, 3);
        llRoot.addView(levelItem);

    }

    @Override
    public void onRootClick(View view) {
        switch ((int)view.getTag()) {
            case 3:
                startActivity(new Intent(MyInfosActivity.this, MySincerityActivity.class));
                break;
        }
    }
}
