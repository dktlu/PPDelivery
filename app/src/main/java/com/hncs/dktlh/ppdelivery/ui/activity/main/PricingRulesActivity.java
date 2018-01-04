package com.hncs.dktlh.ppdelivery.ui.activity.main;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseActivity;
import com.hncs.dktlh.ppdelivery.model.main.ChargeDetailInfo;
import com.hncs.dktlh.ppdelivery.model.main.PricingRulesInfo;
import com.hncs.dktlh.ppdelivery.ui.activity.main.adapter.PricingRulesAdapter;
import com.hncs.dktlh.ppdelivery.ui.activity.main.adapter.PricingRulesHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.share.jack.cygwidget.recyclerview.PtrRecyclerViewUIComponent;
import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerAdapter;
import cn.share.jack.cygwidget.recyclerview.divider.RecyclerViewDivider;
import cn.share.jack.cygwidget.titlebar.TitleBarUIComponent;

public class PricingRulesActivity extends BaseActivity implements CygBaseRecyclerAdapter.OnItemClickListener<PricingRulesHolder> {

    @BindView(R.id.titlebar)
    TitleBarUIComponent mBarUIComponent;
    @BindView(R.id.am_ptr_framelayout)
    PtrRecyclerViewUIComponent ptrRecyclerViewUIComponent;

    private PricingRulesAdapter mAdapter;

    private List<PricingRulesInfo> mPricingRulesInfos;

    @Override
    protected int layoutRes() {
        return R.layout.activity_pricing_rules;
    }

    @Override
    protected void initView() {
        mBarUIComponent.initTitle(getResources().getString(R.string.pricing_rules),
                getResources().getColor(R.color.login_gray_45));
        mBarUIComponent.initLeft(R.mipmap.ic_back_blue, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        initData();

        mAdapter = new PricingRulesAdapter(this, this);
        ptrRecyclerViewUIComponent.setLayoutManager(new LinearLayoutManager(this));
        ptrRecyclerViewUIComponent.setRecyclerViewDivider(
                new RecyclerViewDivider(this, LinearLayoutManager.HORIZONTAL, 1, R.color.pricing_rules_9c));
        ptrRecyclerViewUIComponent.setCanRefresh(false);
        ptrRecyclerViewUIComponent.setAdapter(mAdapter);
        mAdapter.setDataList(mPricingRulesInfos);
    }

    private void initData() {

        mPricingRulesInfos = new ArrayList<>();
        PricingRulesInfo pricingRulesInfo = new PricingRulesInfo();
        pricingRulesInfo.setType(getResources().getString(R.string.standard_distribution_fee));
        List<ChargeDetailInfo> list = new ArrayList<>();
        ChargeDetailInfo info = new ChargeDetailInfo();
        info.setChargeDetail(getResources().getString(R.string.bzpsf_type_1));
        ChargeDetailInfo info1 = new ChargeDetailInfo();
        info1.setChargeDetail(getResources().getString(R.string.bzpsf_type_2));
        list.add(info);
        list.add(info1);
        pricingRulesInfo.setChargeDetailInfos(list);

        PricingRulesInfo pricingRulesInfo1 = new PricingRulesInfo();
        pricingRulesInfo1.setType(getResources().getString(R.string.weight_goods));
        List<ChargeDetailInfo> list1 = new ArrayList<>();
        ChargeDetailInfo info2 = new ChargeDetailInfo();
        info2.setChargeDetail(getResources().getString(R.string.weight_goods_type_1));
        ChargeDetailInfo info3 = new ChargeDetailInfo();
        info3.setChargeDetail(getResources().getString(R.string.weight_goods_type_2));
        list1.add(info2);
        list1.add(info3);
        pricingRulesInfo1.setChargeDetailInfos(list1);

        PricingRulesInfo pricingRulesInfo2 = new PricingRulesInfo();
        pricingRulesInfo2.setType(getResources().getString(R.string.wpjz));
        List<ChargeDetailInfo> list2 = new ArrayList<>();
        ChargeDetailInfo info4 = new ChargeDetailInfo();
        info4.setChargeDetail(getResources().getString(R.string.wpjz_type_1));
        ChargeDetailInfo info5 = new ChargeDetailInfo();
        info5.setChargeDetail(getResources().getString(R.string.wpjz_type_2));
        list2.add(info4);
        list2.add(info5);
        pricingRulesInfo2.setChargeDetailInfos(list2);

        PricingRulesInfo pricingRulesInfo3 = new PricingRulesInfo();
        pricingRulesInfo3.setType(getResources().getString(R.string.jtgj));
        List<ChargeDetailInfo> list3 = new ArrayList<>();
        ChargeDetailInfo info6 = new ChargeDetailInfo();
        info6.setChargeDetail(getResources().getString(R.string.jtgj_type_1));
        ChargeDetailInfo info7 = new ChargeDetailInfo();
        info7.setChargeDetail(getResources().getString(R.string.jtgj_type_2));
        list3.add(info6);
        list3.add(info7);
        pricingRulesInfo3.setChargeDetailInfos(list3);

        PricingRulesInfo pricingRulesInfo4 = new PricingRulesInfo();
        pricingRulesInfo4.setType(getResources().getString(R.string.yjj));
        List<ChargeDetailInfo> list4 = new ArrayList<>();
        ChargeDetailInfo info8 = new ChargeDetailInfo();
        info8.setChargeDetail(getResources().getString(R.string.yjj_type_1));
        ChargeDetailInfo info9 = new ChargeDetailInfo();
        info9.setChargeDetail(getResources().getString(R.string.yjj_type_2));
        list4.add(info8);
        list4.add(info9);
        pricingRulesInfo4.setChargeDetailInfos(list4);

        PricingRulesInfo pricingRulesInfo5 = new PricingRulesInfo();
        pricingRulesInfo5.setType(getResources().getString(R.string.eltq));
        List<ChargeDetailInfo> list5 = new ArrayList<>();
        ChargeDetailInfo info10 = new ChargeDetailInfo();
        info10.setChargeDetail(getResources().getString(R.string.eltq_type_1));
        list5.add(info10);
        pricingRulesInfo5.setChargeDetailInfos(list5);

        PricingRulesInfo pricingRulesInfo6 = new PricingRulesInfo();
        pricingRulesInfo6.setType(getResources().getString(R.string.gjf));
        List<ChargeDetailInfo> list6 = new ArrayList<>();
        ChargeDetailInfo info11 = new ChargeDetailInfo();
        info11.setChargeDetail(getResources().getString(R.string.gjf_type_1));
        list6.add(info11);
        pricingRulesInfo6.setChargeDetailInfos(list6);

        mPricingRulesInfos.add(pricingRulesInfo);
        mPricingRulesInfos.add(pricingRulesInfo1);
        mPricingRulesInfos.add(pricingRulesInfo2);
        mPricingRulesInfos.add(pricingRulesInfo3);
        mPricingRulesInfos.add(pricingRulesInfo4);
        mPricingRulesInfos.add(pricingRulesInfo5);
        mPricingRulesInfos.add(pricingRulesInfo6);
    }

    @Override
    public void onItemClick(int position) {

    }
}
