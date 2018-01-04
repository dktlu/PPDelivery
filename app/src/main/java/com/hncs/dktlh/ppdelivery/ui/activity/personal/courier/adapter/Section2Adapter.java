package com.hncs.dktlh.ppdelivery.ui.activity.personal.courier.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.model.personal.courier.Section2Info;

import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerAdapter;
import cn.share.jack.cygwidget.utils.CygView;

/**
 * Created by dengkaitao on 2018/1/3 15:41.
 * Email：724279138@qq.com
 */

public class Section2Adapter extends CygBaseRecyclerAdapter<Section2Info, Section2Holder> {

    public Section2Adapter(Context context, OnItemClickListener<Section2Holder> listener) {
        super(context, listener);
    }

    @Override
    public Section2Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Section2Holder(
                CygView.inflateLayout(getContext(), R.layout.item_section2, parent, false));
    }
}
