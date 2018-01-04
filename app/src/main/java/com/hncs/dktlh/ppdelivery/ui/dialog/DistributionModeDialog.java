package com.hncs.dktlh.ppdelivery.ui.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.View;
import android.widget.TextView;

import com.eggsy.rxbus.RxBus;
import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.ui.custom.PickerScrollView;
import com.hncs.dktlh.ppdelivery.ui.custom.Pickers;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by dengkaitao on 2017/12/27 15:00.
 * Email：724279138@qq.com
 */

public class DistributionModeDialog extends BaseDialog {

    private Context mContext;
    private List<Pickers> list;//滚动选择器数据
    private String[] id;
    private String[] name;

    @BindView(R.id.picker_view)
    PickerScrollView mPickerScrollView;//滚动选择器
    @BindView(R.id.tv_sure)
    TextView tvSure;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;

    private Pickers selectPicker;

    public DistributionModeDialog(@NonNull Context context) {
        super(context);
        this.mContext = context;
    }

    public DistributionModeDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        this.mContext = context;
    }

    protected DistributionModeDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.mContext = context;
    }

    @Override
    protected int layoutRes() {
        return R.layout.dialog_distribution_mode;
    }

    @Override
    protected void initView() {
        initData();
        mPickerScrollView.setOnSelectListener(pickerListener);
    }

    @OnClick({R.id.tv_cancel, R.id.tv_sure})
    void onClickedView(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel:
                dismiss();
                break;
            case R.id.tv_sure:
                RxBus.post(selectPicker);
                dismiss();
                break;
        }
    }

    private void initData() {
        list = new ArrayList<>();
        id = new String[]{"1", "2", "3"};
        name = new String[]{"不限", "定点自取", "送货上门"};
        for (int i = 0; i < name.length; i++) {
            list.add(new Pickers(name[i], id[i]));
        }
        //设置数据，默认选择第一条
        mPickerScrollView.setData(list);
        mPickerScrollView.setSelected(0);
        selectPicker = new Pickers(name[0], id[0]);
    }

    PickerScrollView.OnSelectListener pickerListener = new PickerScrollView.OnSelectListener() {
        @Override
        public void onSelect(Pickers pickers) {
            selectPicker = new Pickers(pickers.getShowContent(), pickers.getShowId());
            System.out.println("选择：" + selectPicker.getShowId() + "--银行："
                    + selectPicker.getShowContent());
        }
    };
}
