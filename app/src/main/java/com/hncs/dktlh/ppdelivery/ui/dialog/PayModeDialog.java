package com.hncs.dktlh.ppdelivery.ui.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.hncs.dktlh.ppdelivery.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by dengkaitao on 2017/12/31 17:45.
 * Email：724279138@qq.com
 */

public class PayModeDialog extends BaseDialog {

    private Context mContext;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_sure)
    TextView tvSure;

    private OnClickListener mOnClickListener;

    public PayModeDialog(@NonNull Context context) {
        super(context);
        this.mContext = context;
    }

    public void setOnClickListener(OnClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }

    @Override
    protected int layoutRes() {
        return R.layout.dialog_pay_list;
    }

    @Override
    protected void initView() {
        tvCancel.setVisibility(View.INVISIBLE);
        tvTitle.setText(mContext.getResources().getString(R.string.select_pay_mode));
        tvTitle.setTextColor(mContext.getResources().getColor(R.color.gray_333));

        tvSure.setText(mContext.getResources().getString(R.string.cancel));
        tvSure.setTextColor(mContext.getResources().getColor(R.color.pricing_rules_9c));
    }

    @OnClick({R.id.tv_cancel, R.id.tv_sure, R.id.tv_pay})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel:
                break;
            case R.id.tv_sure:
                dismiss();
                break;
            case R.id.tv_pay:
                if (mOnClickListener != null) {
                    mOnClickListener.onClick(view);
                }
                break;
        }
    }

    public interface OnClickListener {
        void onClick(View view);
    }
}
