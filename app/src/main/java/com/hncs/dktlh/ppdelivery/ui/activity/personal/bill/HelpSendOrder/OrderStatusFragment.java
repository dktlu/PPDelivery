package com.hncs.dktlh.ppdelivery.ui.activity.personal.bill.HelpSendOrder;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseFragment;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.balance.adapter.drawbill.CanDrawBillAdapter;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.bill.adapter.OrderStatusAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.share.jack.cygwidget.recyclerview.PtrRecyclerViewUIComponent;
import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerAdapter;

public class OrderStatusFragment extends BaseFragment implements
        CygBaseRecyclerAdapter.OnItemClickListener {

    @BindView(R.id.am_ptr_framelayout)
    PtrRecyclerViewUIComponent ptrRecyclerViewUIComponent;

    private OrderStatusAdapter mAdapter;
    private List<String> mList;

    @Override
    protected int layoutRes() {
        return R.layout.fragment_order_status;
    }

    @Override
    protected void onViewReallyCreated(View view) {
        super.onViewReallyCreated(view);

        mList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            mList.add("i" + i);
        }
        mAdapter = new OrderStatusAdapter(getContext(), this);
        ptrRecyclerViewUIComponent.setLayoutManager(new LinearLayoutManager(getContext()));
        ptrRecyclerViewUIComponent.setCanRefresh(false);
        ptrRecyclerViewUIComponent.setAdapter(mAdapter);
        mAdapter.setDataList(mList);
    }

    @Override
    public void onItemClick(int position) {

    }
}
