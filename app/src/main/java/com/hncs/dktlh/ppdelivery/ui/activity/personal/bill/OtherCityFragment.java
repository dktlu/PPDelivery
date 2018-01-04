package com.hncs.dktlh.ppdelivery.ui.activity.personal.bill;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseFragment;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.bill.adapter.TheCityAdapter;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.bill.adapter.TheCityHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.share.jack.cygwidget.recyclerview.PtrRecyclerViewUIComponent;
import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerAdapter;


public class OtherCityFragment extends BaseFragment implements
        CygBaseRecyclerAdapter.OnItemClickListener<TheCityHolder> {

    @BindView(R.id.am_ptr_framelayout)
    PtrRecyclerViewUIComponent ptrRecyclerViewUIComponent;

    private TheCityAdapter mAdapter;
    private List<String> mList;

    @Override
    protected int layoutRes() {
        return R.layout.fragment_other_city;
    }

    @Override
    protected void onViewReallyCreated(View view) {
        super.onViewReallyCreated(view);


        mList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            mList.add("i" + i);
        }
        mAdapter = new TheCityAdapter(getContext(), this);
        ptrRecyclerViewUIComponent.setLayoutManager(new LinearLayoutManager(getContext()));
        ptrRecyclerViewUIComponent.setCanRefresh(false);
        ptrRecyclerViewUIComponent.setAdapter(mAdapter);
        mAdapter.setDataList(mList);
    }

    @Override
    public void onItemClick(int position) {

    }
}
