package com.hncs.dktlh.ppdelivery.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by dengkaitao on 2017/12/21 16:38.
 * Email：724279138@qq.com
 */

public abstract class BaseFragment<PRESENTER extends BasePresenter> extends Fragment {

    private static final String TAG = "BaseFragment";

    private Unbinder mUnbinder;
    protected abstract int layoutRes();

    protected void onViewReallyCreated(View view) {
    }

    private View rootView;

    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                                   @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (null == rootView) {
            rootView = inflater.inflate(layoutRes(), null);
            mUnbinder = ButterKnife.bind(this, rootView);
            onViewReallyCreated(rootView);
        } else {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {
                parent.removeView(rootView);
            }
        }
        return rootView;
    }

    @Override
    public final void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public <VIEW extends View> VIEW findView(int id) {
        if (null != rootView) {
            View child = rootView.findViewById(id);
            try {
                return (VIEW) child;
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(TAG, "findView: " + String.valueOf(e.getMessage()));
                return null;
            }
        }
        return null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
