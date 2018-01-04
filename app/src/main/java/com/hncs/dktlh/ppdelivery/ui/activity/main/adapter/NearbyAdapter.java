package com.hncs.dktlh.ppdelivery.ui.activity.main.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.hncs.dktlh.ppdelivery.R;

import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerAdapter;
import cn.share.jack.cygwidget.utils.CygView;

/**
 * Created by dengkaitao on 2017/12/24 16:07.
 * Email：724279138@qq.com
 */

public class NearbyAdapter extends CygBaseRecyclerAdapter<String, NearbyHolder> {

    public NearbyAdapter(Context context, OnItemClickListener<NearbyHolder> listener) {
        super(context, listener);
    }

    @Override
    public NearbyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NearbyHolder(
                CygView.inflateLayout(getContext(), R.layout.item_nearby, parent, false));
    }
}
