package com.hncs.dktlh.ppdelivery.ui.activity.main.adapter.message;

import android.content.Context;
import android.view.ViewGroup;

import com.hncs.dktlh.ppdelivery.R;

import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerAdapter;
import cn.share.jack.cygwidget.utils.CygView;

/**
 * Created by dengkaitao on 2017/12/27 10:41.
 * Email：724279138@qq.com
 */

public class SystemMessageAdapter extends CygBaseRecyclerAdapter<String, SystemMessageHolder> {

    public SystemMessageAdapter(Context context, OnItemClickListener<SystemMessageHolder> listener) {
        super(context, listener);
    }

    @Override
    public SystemMessageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SystemMessageHolder(
                CygView.inflateLayout(getContext(), R.layout.item_system_message, parent, false));
    }
}
