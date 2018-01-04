package com.hncs.dktlh.ppdelivery.ui.custom;

import android.content.Context;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hncs.dktlh.ppdelivery.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dengkaitao on 2017/12/26 22:05.
 * Email：724279138@qq.com
 */

public class OverlyingRoundLayout extends LinearLayout {

    private Context mContext;
    private List<RoundedImageView> mImageViews;
    private int count;
    private int[] imgs;

    private OnItemOnclickListener onItemOnclickListener;

    public OverlyingRoundLayout(Context context) {
        this(context, null);
    }

    public OverlyingRoundLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OverlyingRoundLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
    }

    public void setOnItemOnclickListener(OnItemOnclickListener onItemOnclickListener) {
        this.onItemOnclickListener = onItemOnclickListener;
    }

    public void setImageSource(int[] imgs) {
        this.imgs = imgs;
    }

    public void initDatas() {
        mImageViews = new ArrayList<>();
        int size = imgs.length;
        setOrientation(HORIZONTAL);
        for (int i = 0; i < size; i++) {
            if (i < 6) {
                RoundedImageView nearby = new RoundedImageView(mContext);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        dip2px(mContext, 40), dip2px(mContext, 40));
                if (i != 0) {
                    params.setMargins(-dip2px(mContext, 10), 0, 0, 0);
                }
                nearby.setLayoutParams(params);

                nearby.setScaleType(ImageView.ScaleType.FIT_XY);
//                nearby.setCornerRadius(40f);
                nearby.setBorderWidth(4f);
                nearby.setBorderColor(getResources().getColor(R.color.white));
//                nearby.setBackgroundColor(getResources().getColor(R.color.white));
                nearby.setImageResource(imgs[i]);
                nearby.mutateBackground(true);
                nearby.setOval(true);

                final int index = i;
                nearby.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
    //                    Toast.makeText(context, titles[index], Toast.LENGTH_SHORT).show();
                        if(onItemOnclickListener != null) {
                            onItemOnclickListener.onItemClick(index);
                        }
                    }
                });

                if (i == 5) {
                   nearby.setImageResource(R.mipmap.ic_nearby_more);
                }
                addView(nearby);
            }
        }
    }

    public interface OnItemOnclickListener{
        void onItemClick(int index);
    }

    private int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    private int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
