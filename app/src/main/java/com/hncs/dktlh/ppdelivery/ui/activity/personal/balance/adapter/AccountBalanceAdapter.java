package com.hncs.dktlh.ppdelivery.ui.activity.personal.balance.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.hncs.dktlh.ppdelivery.R;

import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerAdapter;
import cn.share.jack.cygwidget.utils.CygView;

/**
 * Created by dengkaitao on 2018/1/2 23:35.
 * Email：724279138@qq.com
 */

public class AccountBalanceAdapter extends CygBaseRecyclerAdapter<String, AccountBalanceHolder> {

    public AccountBalanceAdapter(Context context, OnItemClickListener<AccountBalanceHolder> listener) {
        super(context, listener);
    }

    @Override
    public AccountBalanceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AccountBalanceHolder(
                CygView.inflateLayout(getContext(), R.layout.item_child_sincerity, parent, false));
    }
}
