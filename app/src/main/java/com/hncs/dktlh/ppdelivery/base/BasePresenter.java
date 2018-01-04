package com.hncs.dktlh.ppdelivery.base;

import java.lang.ref.WeakReference;

/**
 * Created by dengkaitao on 2017/12/21 16:30.
 * Email：724279138@qq.com
 */

public class BasePresenter<VIEW> {

    private WeakReference<VIEW> mViews;

    /**
     * 视图加载时
     *
     * @param view
     */
    protected void attachView(VIEW view) {
        mViews = new WeakReference<VIEW>(view);
    }

    //mViews.get()判断对象是否被回收
    protected VIEW getView() {
        return isViewAttached() ? mViews.get() : null;
    }

    /**
     * 视图是否加载到Activity
     *
     * @return
     */
    private boolean isViewAttached() {
        return null != mViews && null != mViews.get();
    }

    /**
     * 视图分离时
     */
    protected void detachView() {
        if (null != mViews) {
            mViews.clear();
            mViews = null;
        }
    }

}
