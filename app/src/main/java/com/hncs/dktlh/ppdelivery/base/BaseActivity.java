package com.hncs.dktlh.ppdelivery.base;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.hncs.dktlh.ppdelivery.R;

import butterknife.ButterKnife;
import cn.share.jack.cyghttp.callback.BaseImpl;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseActivity<PRESENTER extends BasePresenter> extends FragmentActivity implements BaseImpl {

    private CompositeDisposable mCompositeDisposable;

    protected PRESENTER mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (null == mCompositeDisposable) {
            mCompositeDisposable = new CompositeDisposable();
        }
        if (null == mPresenter) {
            mPresenter = createPresenter();
        }
        if (layoutRes() < 0) {
        }
        setContentView(layoutRes());
        ButterKnife.bind(this);
        initView();
    }

    protected abstract int layoutRes();

    protected PRESENTER createPresenter() {
        return null;
    }

    protected abstract void initView();

    @Override
    public boolean addDisposable(Disposable disposable) {
        if (null != mCompositeDisposable) {
            mCompositeDisposable.add(disposable);
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mCompositeDisposable) {
            mCompositeDisposable.clear();
        }
        if (null != mPresenter) {
            mPresenter.detachView();
        }
    }

    @Override
    public Context getContext() {
        return this;
    }
}
