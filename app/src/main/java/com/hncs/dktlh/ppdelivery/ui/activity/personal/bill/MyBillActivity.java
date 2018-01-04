package com.hncs.dktlh.ppdelivery.ui.activity.personal.bill;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseActivity;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.bill.HelpSendOrder.HelpSendOrderActivity;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.bill.adapter.MyBillAdapter;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.bill.adapter.MyBillHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.share.jack.cygwidget.recyclerview.PtrRecyclerViewUIComponent;
import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerAdapter;
import cn.share.jack.cygwidget.titlebar.TitleBarUIComponent;

/**
 * 我的发单界面
 */
public class MyBillActivity extends BaseActivity implements
        CygBaseRecyclerAdapter.OnItemClickListener<MyBillHolder> {

    @BindView(R.id.titlebar)
    TitleBarUIComponent mBarUIComponent;
    @BindView(R.id.am_ptr_framelayout)
    PtrRecyclerViewUIComponent ptrRecyclerViewUIComponent;

    private MyBillAdapter mAdapter;
    private List<String> mList;

    @Override
    protected int layoutRes() {
        return R.layout.activity_my_bill;
    }

    @Override
    protected void initView() {

        mBarUIComponent.initTitle(getResources().getString(R.string.my_order),
                getResources().getColor(R.color.login_gray_45));
        mBarUIComponent.initLeft(R.mipmap.ic_back_blue, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            mList.add("i" + i);
        }
        mAdapter = new MyBillAdapter(this, this);
        ptrRecyclerViewUIComponent.setLayoutManager(new LinearLayoutManager(this));
        ptrRecyclerViewUIComponent.setCanRefresh(false);
        ptrRecyclerViewUIComponent.setAdapter(mAdapter);
        mAdapter.setDataList(mList);
    }

    @Override
    public void onItemClick(int position) {
        startActivity(new Intent(MyBillActivity.this, HelpSendOrderActivity.class));
    }
}
