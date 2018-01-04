package com.hncs.dktlh.ppdelivery.ui.activity.personal.insurance.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.hncs.dktlh.ppdelivery.R;

import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerAdapter;
import cn.share.jack.cygwidget.utils.CygView;

/**
 * Created by dengkaitao on 2018/1/2 23:52.
 * Email：724279138@qq.com
 */

public class InsuranceRecordAdapter extends CygBaseRecyclerAdapter<String, InsuranceRecordHolder> {

    public InsuranceRecordAdapter(Context context, OnItemClickListener<InsuranceRecordHolder> listener) {
        super(context, listener);
    }

    @Override
    public InsuranceRecordHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new InsuranceRecordHolder(
                CygView.inflateLayout(getContext(), R.layout.item_insurance_record, parent, false));
    }
}
