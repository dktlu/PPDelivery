package com.hncs.dktlh.ppdelivery.ui.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.ui.custom.PickValueView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by dengkaitao on 2017/12/28 11:54.
 * Email：724279138@qq.com
 */

public class DistributionToolsDialog extends BaseDialog implements
        PickValueView.onSelectedChangeListener {

    @BindView(R.id.picker_view)
    PickValueView mPickValueView;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_sure)
    TextView tvSure;

    private OnClickListener mOnClickListener;
    private String selectedStr;

    public DistributionToolsDialog(@NonNull Context context) {
        super(context);
    }

    public void setOnClickListener(OnClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }

    @Override
    protected int layoutRes() {
        return R.layout.dialog_time;
    }

    @Override
    protected void initView() {
        String[] middleData = new String[]{"不限", "电瓶车", "驾车", "自行车"};

        mPickValueView.setValueData(middleData, middleData[0]);
    }

    @Override
    public void onSelected(PickValueView view, Object leftValue, Object middleValue, Object rightValue) {
        selectedStr = String.valueOf(middleValue);
//        tvSelected.setText("selected: left:" + left + "  middle:" + middle + "  right:" + right);
    }

    @OnClick({R.id.tv_cancel, R.id.tv_sure})
    void onClickView(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel:
                dismiss();
                break;
            case R.id.tv_sure:
                if (mOnClickListener != null) {
                    mOnClickListener.onClick(view, selectedStr);
                    dismiss();
                }
                break;
        }
    }

    public interface OnClickListener {
        void onClick(View view, String s);
    }
}