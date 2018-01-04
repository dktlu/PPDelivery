package com.hncs.dktlh.ppdelivery.ui.activity.main.adapter.goodsinfo;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.hncs.dktlh.ppdelivery.R;

import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerViewHolder;

/**
 * Created by dengkaitao on 2017/12/28 10:01.
 * Email：724279138@qq.com
 */

public class GoodsInfoHolder extends CygBaseRecyclerViewHolder<String> {

    private TextView tvClassify;

    public GoodsInfoHolder(View view) {
        super(view);
        tvClassify = view.findViewById(R.id.tv_classify);
    }

    @Override
    protected void onItemDataUpdated(@Nullable String s) {
        tvClassify.setText(s);
    }
}
