package com.hncs.dktlh.ppdelivery.ui.activity.personal.balance.adapter.drawbill;

import android.content.Context;
import android.view.ViewGroup;

import com.hncs.dktlh.ppdelivery.R;

import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerAdapter;
import cn.share.jack.cygwidget.utils.CygView;

/**
 * Created by dengkaitao on 2018/1/2 19:33.
 * Email：724279138@qq.com
 */

public class CanDrawBillAdapter extends CygBaseRecyclerAdapter<String, CanDrawBillHolder> {

    public CanDrawBillAdapter(Context context, OnItemClickListener<CanDrawBillHolder> listener) {
        super(context, listener);
    }

    @Override
    public CanDrawBillHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CanDrawBillHolder(
                CygView.inflateLayout(getContext(), R.layout.item_draw_bill, parent, false));
    }
}
