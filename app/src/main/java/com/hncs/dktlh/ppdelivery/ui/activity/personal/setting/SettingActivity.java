package com.hncs.dktlh.ppdelivery.ui.activity.personal.setting;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseActivity;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.MyOneLineView;

import butterknife.BindView;
import cn.share.jack.cygwidget.titlebar.TitleBarUIComponent;

public class SettingActivity extends BaseActivity implements MyOneLineView.OnArrowClickListener,
        MyOneLineView.OnRootClickListener{

    @BindView(R.id.ll_root)
    LinearLayout llRoot;
    @BindView(R.id.titlebar)
    TitleBarUIComponent mBarUIComponent;

    private MyOneLineView soundItem;//声音提醒
    private boolean soundIsOpen = true;//声音开关提示

    private MyOneLineView shockItem;//震动提醒
    private boolean shockIsOpen = true;//震动开关提醒

    private MyOneLineView voiceItem;//语音提醒
    private boolean voiceIsOpen = true;//语音开关提醒

    @Override
    protected int layoutRes() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initView() {

        mBarUIComponent.initTitle(getResources().getString(R.string.setting),
                getResources().getColor(R.color.login_gray_45));
        mBarUIComponent.setBackgroundColor(getResources().getColor(R.color.white));
        mBarUIComponent.initLeft(R.mipmap.ic_back_blue, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //声音提醒
        soundItem = new MyOneLineView(this);
        soundItem.initMine(R.mipmap.ic_setting_sound,
                getResources().getString(R.string.setting_sound_remind),
                "", true);
        soundItem.setIvRightIcon(R.mipmap.ic_setting_open);
        soundItem.setOnArrowClickListener(this, 0);
        soundItem.showDivider(true, true);
        soundItem.setDividerBottomMargin(48, 0, 0, 0);
        soundItem.setRootPaddingLeftRight(15, 15);
        soundItem.setTextContentMargin(17, 0, 0, 0);
        llRoot.addView(soundItem);

        //震动提醒
        shockItem = new MyOneLineView(this);
        shockItem.initMine(R.mipmap.ic_setting_shock,
                getResources().getString(R.string.setting_shock_remind),
                "", true);
        shockItem.setIvRightIcon(R.mipmap.ic_setting_open);
        shockItem.setOnArrowClickListener(this, 1);
        shockItem.showDivider(false, true);
        shockItem.setDividerBottomMargin(48, 0, 0, 0);
        shockItem.setRootPaddingLeftRight(15, 15);
        shockItem.setTextContentMargin(17, 0, 0, 0);
        llRoot.addView(shockItem);

        //语音提醒
        voiceItem = new MyOneLineView(this);
        voiceItem.initMine(R.mipmap.ic_setting_voice,
                getResources().getString(R.string.setting_voice_remind),
                "", true);
        voiceItem.setIvRightIcon(R.mipmap.ic_setting_open);
        voiceItem.setOnArrowClickListener(this, 2);
        voiceItem.setRootPaddingLeftRight(15, 15);
        voiceItem.setTextContentMargin(17, 0, 0, 0);
        voiceItem.showDivider(false, true);
        llRoot.addView(voiceItem);

        View view = new View(this);
        ViewGroup.LayoutParams layoutParams =
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 20);
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(getResources().getColor(R.color.background));
        llRoot.addView(view);

        //修改密码
        MyOneLineView pwdItem = new MyOneLineView(this);
        pwdItem.initMine(R.mipmap.ic_setting_pwd,
                getResources().getString(R.string.setting_change_pwd),
                "", true);
        pwdItem.setIvRightIcon(R.mipmap.ic_personal_right_arrow);
        pwdItem.setRootPaddingLeftRight(15, 15);
        pwdItem.setTextContentMargin(17, 0, 0, 0);
        pwdItem.setDividerBottomMargin(48, 0, 0, 0);
        pwdItem.showDivider(true, true);
        pwdItem.setOnRootClickListener(this, 0);
        llRoot.addView(pwdItem);

        //关于人人递吧
        MyOneLineView aboutItem = new MyOneLineView(this);
        aboutItem.initMine(R.mipmap.ic_setting_about,
                getResources().getString(R.string.setting_aboutus),
                "", true);
        aboutItem.setIvRightIcon(R.mipmap.ic_personal_right_arrow);
        aboutItem.setRootPaddingLeftRight(15, 15);
        aboutItem.setTextContentMargin(17, 0, 0, 0);
        aboutItem.showDivider(false, true);
        aboutItem.setOnRootClickListener(this, 1);
        llRoot.addView(aboutItem);

        View view1 = new View(this);
        ViewGroup.LayoutParams layoutParams1 =
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 20);
        view1.setLayoutParams(layoutParams);
        view1.setBackgroundColor(getResources().getColor(R.color.background));
        llRoot.addView(view1);

        //最新版本
        MyOneLineView versionItem = new MyOneLineView(this);
        versionItem.initMine(R.mipmap.ic_setting_version,
                getResources().getString(R.string.setting_version),
                "", true);
        versionItem.setIvRightIcon(R.mipmap.ic_personal_right_arrow);
        versionItem.setRootPaddingLeftRight(15, 15);
        versionItem.setTextContentMargin(17, 0, 0, 0);
        versionItem.showDivider(true, true);
        versionItem.setOnRootClickListener(this, 2);
        llRoot.addView(versionItem);
    }

    @Override
    public void onArrowClick(View view) {
        switch ((Integer) view.getTag()) {
            case 0://声音提醒
                if (soundIsOpen) {
                    soundIsOpen = false;
                    soundItem.setIvRightIcon(R.mipmap.ic_setting_close);
                } else {
                    soundIsOpen = true;
                    soundItem.setIvRightIcon(R.mipmap.ic_setting_open);
                }
                break;
            case 1://震动提醒
                if (shockIsOpen) {
                    shockIsOpen = false;
                    shockItem.setIvRightIcon(R.mipmap.ic_setting_close);
                } else {
                    shockIsOpen = true;
                    shockItem.setIvRightIcon(R.mipmap.ic_setting_open);
                }
                break;
            case 2://语音提醒
                if (voiceIsOpen) {
                    voiceIsOpen = false;
                    voiceItem.setIvRightIcon(R.mipmap.ic_setting_close);
                } else {
                    voiceIsOpen = true;
                    voiceItem.setIvRightIcon(R.mipmap.ic_setting_open);
                }
                break;
        }
    }

    @Override
    public void onRootClick(View view) {
        switch ((Integer)view.getTag()) {
            case 0:
                startActivity(new Intent(this, ChangePwdActivity.class));
                break;
            case 1:

                break;
            case 2:

                break;
        }
    }
}
