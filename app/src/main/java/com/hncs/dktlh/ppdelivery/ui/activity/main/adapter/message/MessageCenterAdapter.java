package com.hncs.dktlh.ppdelivery.ui.activity.main.adapter.message;

import android.content.Context;
import android.view.ViewGroup;

import com.hncs.dktlh.ppdelivery.R;

import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerAdapter;
import cn.share.jack.cygwidget.utils.CygView;

/**
 * Created by dengkaitao on 2017/12/27 10:24.
 * Email：724279138@qq.com
 */

public class MessageCenterAdapter extends CygBaseRecyclerAdapter<String, MessageCenterHolder> {

    public MessageCenterAdapter(Context context, OnItemClickListener<MessageCenterHolder> listener) {
        super(context, listener);
    }

    @Override
    public MessageCenterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MessageCenterHolder(
                CygView.inflateLayout(getContext(), R.layout.item_msg_center, parent, false));
    }
}
