package com.hncs.dktlh.ppdelivery.ui.activity.login;

import android.content.Intent;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseActivity;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.MyOneLineView;

import butterknife.BindView;
import cn.share.jack.cygwidget.titlebar.TitleBarUIComponent;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.titlebar)
    TitleBarUIComponent titlebar;
    @BindView(R.id.ll_root)
    LinearLayout llRoot;
    @BindView(R.id.tv_registration)
    TextView tvRegistration;

    @Override
    protected int layoutRes() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {

        titlebar.initTitle(
                getResources().getString(R.string.registration),
                getResources().getColor(R.color.login_gray_45));
        titlebar.initLeft(R.mipmap.ic_back_blue, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //手机号码
        MyOneLineView phoneItem = new MyOneLineView(this);
        phoneItem.initItemWidthEdit(
                R.mipmap.ic_login_phone, "", getResources().getString(R.string.hint_input_phone));
        phoneItem.setRootPaddingLeftRight(0, 0);
        phoneItem.setEditMargin(20, 0, 20, 0);
        phoneItem.setRightText(getResources().getString(R.string.get_code));
        phoneItem.setRightTextColor(R.color.login_blue_1A);
        phoneItem.setDividerBottomColor(R.color.my_divider);
        phoneItem.showTextContent(false);
        phoneItem.setDividerTopHigiht(1);
        phoneItem.showDivider(false, true);

        //验证码
        MyOneLineView codeItem = new MyOneLineView(this);
        codeItem.initItemWidthEdit(
                R.mipmap.ic_login_code, "", getResources().getString(R.string.hint_input_code));
        codeItem.setRootPaddingLeftRight(0, 0);
        codeItem.setEditMargin(20, 0, 20, 0);
        codeItem.setDividerBottomColor(R.color.my_divider);
        codeItem.showTextContent(false);
        codeItem.setDividerTopHigiht(1);
        codeItem.showDivider(false, true);

        //密码
        MyOneLineView pwdItem = new MyOneLineView(this);
        pwdItem.initItemWidthEdit(
                R.mipmap.ic_login_pwd, "", getResources().getString(R.string.hint_input_pwd));
        pwdItem.setRootPaddingLeftRight(0, 0);
        pwdItem.setEditMargin(20, 0, 20, 0);
        pwdItem.setDividerBottomColor(R.color.my_divider);
        pwdItem.showTextContent(false);
        pwdItem.setDividerTopHigiht(1);
        pwdItem.showDivider(false, true);

        //密码
        MyOneLineView inviterItem = new MyOneLineView(this);
        inviterItem.initItemWidthEdit(
                R.mipmap.ic_register_inviter, "", getResources().getString(R.string.hint_inviter_phone));
        inviterItem.setRootPaddingLeftRight(0, 0);
        inviterItem.setEditMargin(20, 0, 20, 0);
        inviterItem.setDividerBottomColor(R.color.my_divider);
        inviterItem.showTextContent(false);
        inviterItem.setDividerTopHigiht(1);
        inviterItem.showDivider(false, true);

        llRoot.addView(phoneItem);
        llRoot.addView(codeItem);
        llRoot.addView(pwdItem);
        llRoot.addView(inviterItem);

        //这个一定要记得设置，不然点击不生效
        tvRegistration.setMovementMethod(LinkMovementMethod.getInstance());
        SpannableStringBuilder spannable = new SpannableStringBuilder(tvRegistration.getText());
        spannable.setSpan(new TextClick(), 7, tvRegistration.getText().length()
                , Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvRegistration.setText(spannable);
    }

    private class TextClick extends ClickableSpan {

        @Override
        public void onClick(View widget) {
            startActivity(new Intent(RegisterActivity.this, RegistrationClauseActivity.class));
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(getResources().getColor(R.color.login_blue_1A));
        }
    }
}
