package com.hncs.dktlh.ppdelivery.ui.activity.main.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.hncs.dktlh.ppdelivery.R;
import com.makeramen.roundedimageview.RoundedImageView;

import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerViewHolder;

/**
 * Created by dengkaitao on 2017/12/24 16:09.
 * Email：724279138@qq.com
 */

public class NearbyHolder extends CygBaseRecyclerViewHolder<String> {

    private RoundedImageView mImageView;

    public NearbyHolder(View view) {
        super(view);
        mImageView = findView(R.id.riv_header);
    }

    @Override
    protected void onItemDataUpdated(@Nullable String s) {
        mImageView.setBackgroundDrawable(getContext().getResources().getDrawable(R.mipmap.ic_launcher));
    }
}
