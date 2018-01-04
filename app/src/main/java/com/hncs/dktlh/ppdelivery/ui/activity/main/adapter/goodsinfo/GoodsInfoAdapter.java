package com.hncs.dktlh.ppdelivery.ui.activity.main.adapter.goodsinfo;

import android.content.Context;
import android.view.ViewGroup;

import com.hncs.dktlh.ppdelivery.R;

import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerAdapter;
import cn.share.jack.cygwidget.utils.CygView;

/**
 * Created by dengkaitao on 2017/12/28 10:01.
 * Email：724279138@qq.com
 */

public class GoodsInfoAdapter extends CygBaseRecyclerAdapter<String, GoodsInfoHolder> {

    public GoodsInfoAdapter(Context context, OnItemClickListener<GoodsInfoHolder> listener) {
        super(context, listener);
    }

    @Override
    public GoodsInfoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GoodsInfoHolder(
                CygView.inflateLayout(getContext(), R.layout.item_goods_info, parent, false));
    }
}
