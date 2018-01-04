package com.hncs.dktlh.ppdelivery.ui.activity.personal.balance.drawbill;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseFragment;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.balance.adapter.drawbill.CanDrawBillAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.share.jack.cygwidget.recyclerview.PtrRecyclerViewUIComponent;
import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerAdapter;

public class CanDrawBillFragment extends BaseFragment implements
        CygBaseRecyclerAdapter.OnItemClickListener {

    @BindView(R.id.am_ptr_framelayout)
    PtrRecyclerViewUIComponent ptrRecyclerViewUIComponent;

    private CanDrawBillAdapter mAdapter;
    private List<String> mList;

    @Override
    protected int layoutRes() {
        return R.layout.fragment_can_draw_bill;
    }

    @Override
    protected void onViewReallyCreated(View view) {
        super.onViewReallyCreated(view);

        mList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            mList.add("i" + i);
        }
        mAdapter = new CanDrawBillAdapter(getContext(), this);
        ptrRecyclerViewUIComponent.setLayoutManager(new LinearLayoutManager(getContext()));
        ptrRecyclerViewUIComponent.setCanRefresh(false);
        ptrRecyclerViewUIComponent.setAdapter(mAdapter);
        mAdapter.setDataList(mList);
    }

    @Override
    public void onItemClick(int position) {

    }

    @OnClick({R.id.tv_next})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_next:
                startActivity(new Intent(getActivity(), DrawBillDetailActivity.class));
                break;
        }
    }
}
