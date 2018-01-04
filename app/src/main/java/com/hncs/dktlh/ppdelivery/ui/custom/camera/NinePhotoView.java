package com.hncs.dktlh.ppdelivery.ui.custom.camera;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.utils.DensityUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dengkaitao on 2017/12/30 14:06.
 * Email：724279138@qq.com
 */

public class NinePhotoView extends ViewGroup {

    private  Context mContext;
    /**
     * 最大显示图片数量
     */
    private int MAX_PHOTO_MUMBER = 9;
    private String[] constImagePath;
    private List<File> imageFileList;
    /**
     * 图片之间的水平间隔
     */
    private int hSpace = 10;
    /**
     * 图片之间的垂直间隔
     */
    private int vSpace = 10;
    /**
     * 添加图片的视图
     */
    private View addPhotoView;
    private int addPhotoResId;

    private int childWidth;
    private int childHeight;

    private OnAddClickListener mAddClickListener;

    public NinePhotoView(Context context) {
        this(context, null);
    }

    public NinePhotoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public void setOnAddClickListener(OnAddClickListener listener) {
        this.mAddClickListener = listener;
    }

    public NinePhotoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;

        TypedArray typedArray = mContext.obtainStyledAttributes(
                attrs, R.styleable.NinePhotoView, 0, 0);
        hSpace = typedArray.getDimensionPixelSize(
                R.styleable.NinePhotoView_ninephoto_hspace, hSpace);
        vSpace = typedArray.getDimensionPixelSize(
                R.styleable.NinePhotoView_ninephoto_vspace, vSpace);
        typedArray.recycle();

        addPhotoView = new View(mContext);
        addView(addPhotoView);

        imageFileList = new ArrayList<>();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int rw = MeasureSpec.getSize(widthMeasureSpec);
        int rh = MeasureSpec.getSize(heightMeasureSpec);

        childWidth = (rw - 2 * hSpace) / 3;
        childHeight = childWidth;

        int childCount = this.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = this.getChildAt(i);
            LayoutParams lParams = child.getLayoutParams();
//            lParams.left = (i % 3) * (childWidth + hSpace);
//            lParams.top = (i / 3) * (childWidth + vSpace);
            child.setLeft((i % 3) * (childWidth + hSpace));
            child.setTop((i / 3) * (childWidth + vSpace));
        }
        int vw = rw;
        int vh = rh;
        if (childCount < 3) {
            vw = childCount * (childWidth + hSpace);
        }
        vh = ((childCount + 3) / 3) * (childWidth + vSpace);
        setMeasuredDimension(vw, vh);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        int childCount = this.getChildCount();
        for (int j = 0; j < childCount; j++) {
            View child = this.getChildAt(j);
            LayoutParams lParams = (LayoutParams) child.getLayoutParams();
            child.layout(child.getLeft(), child.getTop(), child.getLeft() + childWidth,
                    child.getTop() + childHeight);

            if (j == imageFileList.size() - 1
                    && imageFileList.size() != MAX_PHOTO_MUMBER || imageFileList.size() == 0) {
                child.setBackgroundResource(addPhotoResId);
                child.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mAddClickListener.onClick(view);
                    }
                });
            } else if (j < imageFileList.size() - 1) {
                Glide.with(mContext).load(imageFileList.get(j)).into((ImageView) child);
                child.setOnClickListener(null);
            }
        }
    }

    /**
     * 设置添加图片资源
     * @param resId
     */
    public void setAddPhotoResId(int resId) {
        this.addPhotoResId = resId;
    }

    /**
     * 添加图片
     * @param file
     */
    public void addPhoto(File file) {
        if (imageFileList.size() < MAX_PHOTO_MUMBER) {
            View newChild = new View(getContext());
            addView(newChild);
            imageFileList.add(file);
            Log.e("fewf", "path = " + file.getAbsolutePath());
            requestLayout();
            invalidate();
        } else {
            Toast.makeText(mContext, "最大添加数量为" + MAX_PHOTO_MUMBER + "张", Toast.LENGTH_LONG).show();
        }
    }

    public interface OnAddClickListener {
        void onClick(View view);
    }
}
