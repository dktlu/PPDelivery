package com.hncs.dktlh.ppdelivery.ui.dialog;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hncs.dktlh.ppdelivery.R;

import butterknife.BindView;

/**
 * Created by dengkaitao on 2017/12/27 22:41.
 * Email：724279138@qq.com
 */

public class IncreasePriceDialog extends BaseDialog {

    private Context mContext;
    @BindView(R.id.radioGroup)
    RadioGroup mRadioGroup;
    @BindView(R.id.rl_rmb)
    RelativeLayout rlRmb;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_sure)
    TextView tvSure;

    public IncreasePriceDialog(@NonNull Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    protected int layoutRes() {
        return R.layout.dialog_add_price;
    }

    @Override
    protected void initView() {
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        tvTitle.setText(mContext.getResources().getString(R.string.thanks_rmb));
        tvSure.setVisibility(View.INVISIBLE);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.rb_other) {
                    rlRmb.setVisibility(View.VISIBLE);
                    mRadioGroup.setVisibility(View.GONE);
                }
            }
        });
    }
}
