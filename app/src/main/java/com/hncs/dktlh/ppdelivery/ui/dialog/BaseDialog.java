package com.hncs.dktlh.ppdelivery.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.hncs.dktlh.ppdelivery.R;

import butterknife.ButterKnife;

/**
 * Created by dengkaitao on 2017/12/27 22:17.
 * Email：724279138@qq.com
 */

public abstract class BaseDialog extends Dialog {

    private Context mContext;
    private int gravity = Gravity.BOTTOM;

    public BaseDialog(@NonNull Context context) {
        super(context, R.style.MyDialog);
        this.mContext = context;
    }

    public BaseDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        this.mContext = context;
    }

    protected BaseDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.mContext = context;
    }

    protected abstract int layoutRes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = View.inflate(mContext, layoutRes(), null);
        setContentView(view);
        setCanceledOnTouchOutside(false);
        ButterKnife.bind(this);
        initView();
    }

    protected abstract void initView();

    @Override
    public void show() {
        super.show();
        setWindow();
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    private void setWindow() {
        Window win = getWindow();
        WindowManager.LayoutParams lp = win.getAttributes();
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        win.setGravity(gravity);
        win.getDecorView().setPadding(0, 0, 0, 0);
        win.setAttributes(lp);
    }
}
