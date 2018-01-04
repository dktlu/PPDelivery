package com.hncs.dktlh.ppdelivery.ui.activity.personal.bill.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.hncs.dktlh.ppdelivery.R;

import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerAdapter;
import cn.share.jack.cygwidget.utils.CygView;

/**
 * Created by dengkaitao on 2017/12/29 14:22.
 * Email：724279138@qq.com
 */

public class TheCityAdapter extends CygBaseRecyclerAdapter<String, TheCityHolder> {

    public TheCityAdapter(Context context, OnItemClickListener<TheCityHolder> listener) {
        super(context, listener);
    }

    @Override
    public TheCityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TheCityHolder(
                CygView.inflateLayout(getContext(), R.layout.item_my_dispatch, parent, false));
    }
}
