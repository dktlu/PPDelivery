package com.hncs.dktlh.ppdelivery.ui.activity.personal.bill.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.hncs.dktlh.ppdelivery.R;

import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerAdapter;
import cn.share.jack.cygwidget.utils.CygView;

/**
 * Created by dengkaitao on 2017/12/28 23:04.
 * Email：724279138@qq.com
 */

public class MyBillAdapter extends CygBaseRecyclerAdapter<String, MyBillHolder> {

    public MyBillAdapter(Context context, OnItemClickListener<MyBillHolder> listener) {
        super(context, listener);
    }

    @Override
    public MyBillHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyBillHolder(
                CygView.inflateLayout(getContext(), R.layout.item_my_bill, parent, false));
    }
}
