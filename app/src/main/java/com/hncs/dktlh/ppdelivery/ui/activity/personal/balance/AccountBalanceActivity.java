package com.hncs.dktlh.ppdelivery.ui.activity.personal.balance;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseActivity;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.balance.adapter.AccountBalanceAdapter;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.balance.adapter.AccountBalanceHolder;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.balance.drawbill.DrawBillActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.share.jack.cygwidget.recyclerview.PtrRecyclerViewUIComponent;
import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerAdapter;
import cn.share.jack.cygwidget.titlebar.TitleBarUIComponent;

/**
 * 账户余额界面
 */
public class AccountBalanceActivity extends BaseActivity implements
        CygBaseRecyclerAdapter.OnItemClickListener<AccountBalanceHolder> {

    @BindView(R.id.titlebar)
    TitleBarUIComponent mBarUIComponent;
    @BindView(R.id.am_ptr_framelayout)
    PtrRecyclerViewUIComponent ptrRecyclerViewUIComponent;

    private AccountBalanceAdapter mAdapter;
    private List<String> mList;

    @Override
    protected int layoutRes() {
        return R.layout.activity_account_balance;
    }

    @Override
    protected void initView() {

        mBarUIComponent.initTitle(getResources().getString(R.string.account_balance),
                getResources().getColor(R.color.login_gray_45));
        mBarUIComponent.initRight(
                getResources().getString(R.string.draw_bill), new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AccountBalanceActivity.this, DrawBillActivity.class));
            }
        });
        mBarUIComponent.setRightTextColor(
                getResources().getColor(R.color.login_blue_1A));
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
        mAdapter = new AccountBalanceAdapter(this, this);
        ptrRecyclerViewUIComponent.setLayoutManager(new LinearLayoutManager(this));
        ptrRecyclerViewUIComponent.setCanRefresh(false);
        ptrRecyclerViewUIComponent.setAdapter(mAdapter);
        mAdapter.setDataList(mList);
    }

    @Override
    public void onItemClick(int position) {

    }

    @OnClick({R.id.tv_withdrawals, R.id.btn_withdrawals})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_withdrawals:
            case R.id.btn_withdrawals://提现
                startActivity(new Intent(AccountBalanceActivity.this, WithdrawalsActivity.class));
                break;
        }
    }
}
