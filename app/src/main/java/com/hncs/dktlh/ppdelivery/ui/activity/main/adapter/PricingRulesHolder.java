package com.hncs.dktlh.ppdelivery.ui.activity.main.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.model.main.PricingRulesInfo;

import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerViewHolder;

/**
 * Created by dengkaitao on 2017/12/23 16:27.
 * Email：724279138@qq.com
 */

public class PricingRulesHolder extends CygBaseRecyclerViewHolder<PricingRulesInfo> {

    private TextView tvKey;
    private LinearLayout llRoot;

    public PricingRulesHolder(View view) {
        super(view);
        tvKey = (TextView) findView(R.id.tv_key);
        llRoot = (LinearLayout) findView(R.id.ll_root);
    }

    @Override
    protected void onItemDataUpdated(@Nullable PricingRulesInfo infos) {
        if (null != infos) {
            tvKey.setText(infos.getType());
            for (int i = 0; i < infos.getChargeDetailInfos().size(); i++) {
                TextView textView = new TextView(getContext());
                textView.setText(infos.getChargeDetailInfos().get(i).getChargeDetail());
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(24, 30, 24, 30);
                textView.setLayoutParams(params);
                llRoot.addView(textView);

                if (i != infos.getChargeDetailInfos().size() - 1) {
                    View view = new View(getContext());
                    LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT, 2);
                    view.setLayoutParams(params1);
                    view.setBackgroundColor(getContext().getResources().getColor(R.color.pricing_rules_9c));
                    llRoot.addView(view);
                }
            }
        }
    }
}
