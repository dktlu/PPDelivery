package com.hncs.dktlh.ppdelivery.ui.custom.flowlayout;

import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dengkaitao on 2017/12/30 11:25.
 * Email：724279138@qq.com
 */
public abstract class FlowAdapter<T> {
    private List<T> mList;

    public FlowAdapter(List<T> datas) {
        mList = datas;
    }
    public FlowAdapter(T[] datas) {
        mList = new ArrayList<T>(Arrays.asList(datas));
    }

    public T getItem(int position) {
        return mList.get(position);
    }

    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    public abstract View getView(int position);
}
