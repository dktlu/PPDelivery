package com.hncs.dktlh.ppdelivery.ui.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.hncs.dktlh.ppdelivery.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by dengkaitao on 2017/12/28 17:19.
 * Email：724279138@qq.com
 */

public class EditValueDialog extends BaseDialog {

    private Context mContext;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_sure)
    TextView tvSure;
    @BindView(R.id.et_number)
    EditText etNumber;
    @BindView(R.id.btn_sure)
    TextView btnSure;
    @BindView(R.id.tv_unit)
    TextView tvUnit;

    private OnClickListener mOnClickListener;
    private int titleId;
    private int hintId;
    private int unitId;

    public EditValueDialog(@NonNull Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    protected int layoutRes() {
        return R.layout.dialog_edit_sure;
    }

    @Override
    protected void initView() {
        if (titleId != 0) {
            tvTitle.setText(mContext.getResources().getString(titleId));
        }
        if (hintId != 0) {
            etNumber.setHint(mContext.getResources().getString(hintId));
        }
        if (unitId != 0) {
            tvUnit.setText(mContext.getResources().getString(unitId));
        }
        tvSure.setVisibility(View.INVISIBLE);
    }

    public void setOnClickListener(OnClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }

    public void setTitle(int titleId) {
        this.titleId = titleId;
    }

    public void setEditHint(int hintId) {
        this.hintId = hintId;
    }

    public void setUnit(int unitId) {
        this.unitId = unitId;
    }

    @OnClick({R.id.tv_cancel, R.id.btn_sure})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel:
                dismiss();
                break;
            case R.id.btn_sure:
                if (mOnClickListener != null) {
                    mOnClickListener.onClick(view, etNumber.getText().toString() + tvUnit.getText().toString());
                    dismiss();
                }
                break;
        }
    }

    public interface OnClickListener {
        void onClick(View view, String s);
    }
}
