package com.hncs.dktlh.ppdelivery.ui.activity.personal.bill.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.hncs.dktlh.ppdelivery.R;

import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerAdapter;
import cn.share.jack.cygwidget.utils.CygView;

/**
 * Created by dengkaitao on 2018/1/3 16:38.
 * Email：724279138@qq.com
 */

public class OrderStatusAdapter extends CygBaseRecyclerAdapter<String, OrderStatusHolder> {

    private static final int VIEW_TYPE_1 = 0x1;
    private static final int VIEW_TYPE_2 = 0x2;

    public OrderStatusAdapter(Context context, OnItemClickListener<OrderStatusHolder> listener) {
        super(context, listener);
    }

    @Override
    public OrderStatusHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OrderStatusHolder(
                CygView.inflateLayout(getContext(), R.layout.item_order_status_type1, parent, false));
    }
}
