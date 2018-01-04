package com.hncs.dktlh.ppdelivery.ui.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.hncs.dktlh.ppdelivery.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by dengkaitao on 2018/1/2 17:31.
 * Email：724279138@qq.com
 */

public class OrderStatusDialog extends BaseDialog {

    private Context mContext;

    @BindView(R.id.tv_cancel)
    TextView tvCancel;

    public OrderStatusDialog(@NonNull Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    protected int layoutRes() {
        return R.layout.layout_order_status;
    }

    @Override
    protected void initView() {

    }

    @OnClick({R.id.tv_cancel})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel:
                dismiss();
                break;
        }
    }
}
