package com.hncs.dktlh.ppdelivery.ui.activity.main.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.model.main.PricingRulesInfo;

import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerAdapter;
import cn.share.jack.cygwidget.utils.CygView;

/**
 * Created by dengkaitao on 2017/12/23 16:39.
 * Email：724279138@qq.com
 */

public class PricingRulesAdapter extends CygBaseRecyclerAdapter<PricingRulesInfo, PricingRulesHolder> {

    public PricingRulesAdapter(Context context, OnItemClickListener<PricingRulesHolder> listener) {
        super(context, listener);
    }

    @Override
    public PricingRulesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PricingRulesHolder(
                CygView.inflateLayout(getContext(), R.layout.item_pricing_rules, parent, false));
    }
}
