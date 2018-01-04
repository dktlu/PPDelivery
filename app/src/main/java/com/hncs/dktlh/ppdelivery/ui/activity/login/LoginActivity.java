package com.hncs.dktlh.ppdelivery.ui.activity.login;

import android.content.Intent;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseActivity;
import com.hncs.dktlh.ppdelivery.ui.activity.main.MainActivity;

import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import cn.share.jack.cygwidget.titlebar.TitleBarUIComponent;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.titlebar)
    TitleBarUIComponent titlebar;
    @BindView(R.id.cb_login_quick)
    CheckBox cbLoginQuick;
    @BindView(R.id.cb_login_pwd)
    CheckBox cbLoginPassword;
    @BindView(R.id.tv_get_code)
    TextView tvGetCode;
    @BindView(R.id.iv_login_code)
    ImageView ivLoginCode;
    @BindView(R.id.et_code)
    EditText etCode;
    @BindView(R.id.cb_pwd_show)
    CheckBox cbPwdShow;

    @Override
    protected int layoutRes() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

        titlebar.initTitle(
                getResources().getString(R.string.login),
                getResources().getColor(R.color.login_gray_45));
        titlebar.initLeft(R.mipmap.ic_back_blue, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        titlebar.setRightTextColor(getResources().getColor(R.color.login_blue_1A));
        titlebar.initRight(getResources().getString(R.string.registration),
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                    }
                });

        etCode.setSelection(etCode.getText().length());
        displayQuickMode();
    }

    /**
     * 显示快速登陆视图
     */
    private void displayQuickMode() {
        cbLoginPassword.setChecked(false);
        tvGetCode.setVisibility(View.VISIBLE);
        ivLoginCode.setImageDrawable(getResources().getDrawable(R.mipmap.ic_login_code));
        etCode.setText("");
        etCode.setHint(R.string.hint_input_code);
        cbPwdShow.setVisibility(View.GONE);
    }

    /**
     * 显示密码登陆视图
     */
    private void displayPwdMode() {
        cbLoginQuick.setChecked(false);
        tvGetCode.setVisibility(View.GONE);
        ivLoginCode.setImageDrawable(getResources().getDrawable(R.mipmap.ic_login_pwd));
        etCode.setText("");
        etCode.setHint(R.string.hint_input_pwd);
        cbPwdShow.setVisibility(View.VISIBLE);
    }

    @OnCheckedChanged({R.id.cb_login_pwd, R.id.cb_login_quick})
    void onCheckedChanged(CompoundButton cb, boolean isChecked) {
        switch (cb.getId()) {
            case R.id.cb_login_pwd:
                if (isChecked) {
                    displayPwdMode();
                } else {
                    displayQuickMode();
                }
                break;
            case R.id.cb_login_quick:
                if (isChecked) {
                    displayQuickMode();
                } else {
                    displayPwdMode();
                }
                break;
        }
    }

    @OnCheckedChanged(R.id.cb_pwd_show)
    void onClickDisplayPwd(boolean isChecked) {
        if (isChecked) {
            etCode.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        } else {
            etCode.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }

    @OnClick(R.id.btn_login)
    void onClickLogin(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}
