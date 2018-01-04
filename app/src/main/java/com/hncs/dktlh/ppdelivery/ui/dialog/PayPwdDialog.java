package com.hncs.dktlh.ppdelivery.ui.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.hncs.dktlh.ppdelivery.R;

import butterknife.OnClick;

/**
 * Created by dengkaitao on 2017/12/31 18:35.
 * Email：724279138@qq.com
 */

public class PayPwdDialog extends BaseDialog {

    private Context mContext;

    public PayPwdDialog(@NonNull Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    protected int layoutRes() {
        return R.layout.dialog_pay_pwd;
    }

    @Override
    protected void initView() {

    }

    @OnClick({R.id.tv_cancel, R.id.tv_sure})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel:
                dismiss();
                break;
            case R.id.tv_sure:
                dismiss();
                break;
        }
    }
}
