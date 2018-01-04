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
 * Created by dengkaitao on 2017/12/28 0:05.
 * Email：724279138@qq.com
 */

public class PickTimeDialog extends BaseDialog implements PickValueView.onSelectedChangeListener {

    private Context mContext;
    @BindView(R.id.picker_view)
    PickValueView mPickValueView;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_sure)
    TextView tvSure;
    private int titleResId;
    private OnClickListener mOnClickListener;
    private String selectedStr;

    public PickTimeDialog(@NonNull Context context) {
        super(context);
        this.mContext = context;
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
        String[] leftData = mContext.getResources().getStringArray(R.array.pick_time_left);
        String[] middleData = mContext.getResources().getStringArray(R.array.pick_time_middel);
        String[] rightData = mContext.getResources().getStringArray(R.array.pick_time_right);;

        mPickValueView.setValueData(leftData, leftData[0], middleData, middleData[0], rightData, rightData[0]);
        mPickValueView.setOnSelectedChangeListener(this);
        tvTitle.setText(mContext.getResources().getString(titleResId));
        selectedStr = leftData[0] + middleData[0] + rightData[0];
    }

    public void setTitle(int titleResId) {
        this.titleResId = titleResId;
    }

    @Override
    public void onSelected(PickValueView view, Object leftValue, Object middleValue, Object rightValue) {
        String left = String.valueOf(leftValue);
        String middle = String.valueOf(middleValue);
        String right = String.valueOf(rightValue);
        selectedStr = left + middle + right;
        System.out.println("selected: left:" + left + "  middle:" + middle + "  right:" + right);
//        tvSelected.setText("selected: left:" + left + "  middle:" + middle + "  right:" + right);
    }

    @OnClick({R.id.tv_cancel, R.id.tv_sure})
    void onClick(View view) {
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
