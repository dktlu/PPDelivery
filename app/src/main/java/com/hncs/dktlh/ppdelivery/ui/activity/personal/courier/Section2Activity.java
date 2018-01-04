package com.hncs.dktlh.ppdelivery.ui.activity.personal.courier;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseActivity;
import com.hncs.dktlh.ppdelivery.model.personal.courier.Section2Info;
import com.hncs.dktlh.ppdelivery.ui.activity.main.adapter.PricingRulesAdapter;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.courier.adapter.Section2Adapter;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.courier.adapter.Section2Holder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.share.jack.cygwidget.recyclerview.PtrRecyclerViewUIComponent;
import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerAdapter;
import cn.share.jack.cygwidget.recyclerview.divider.RecyclerViewDivider;
import cn.share.jack.cygwidget.titlebar.TitleBarUIComponent;

public class Section2Activity extends BaseActivity implements
        CygBaseRecyclerAdapter.OnItemClickListener<Section2Holder> {

    @BindView(R.id.titlebar)
    TitleBarUIComponent mBarUIComponent;
    @BindView(R.id.am_ptr_framelayout)
    PtrRecyclerViewUIComponent ptrRecyclerViewUIComponent;

    private Section2Adapter mAdapter;
    private List<Section2Info> mSection2Infos;

    @Override
    protected int layoutRes() {
        return R.layout.activity_section2;
    }

    @Override
    protected void initView() {
        mBarUIComponent.initTitle(getResources().getString(R.string.section2_title),
                getResources().getColor(R.color.login_gray_45));
        mBarUIComponent.initLeft(R.mipmap.ic_back_blue, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        initData();

        mAdapter = new Section2Adapter(this, this);
        ptrRecyclerViewUIComponent.setLayoutManager(new LinearLayoutManager(this));
        ptrRecyclerViewUIComponent.setRecyclerViewDivider(
                new RecyclerViewDivider(this, LinearLayoutManager.HORIZONTAL, 1, R.color.my_divider));
        ptrRecyclerViewUIComponent.setCanRefresh(false);
        ptrRecyclerViewUIComponent.setAdapter(mAdapter);
        mAdapter.setDataList(mSection2Infos);
    }

    private void initData() {
        mSection2Infos = new ArrayList<>();

        Section2Info section2Info1 = new Section2Info();
        section2Info1.setNumber("1. 单选题");
        section2Info1.setQuestion("每次致电发货人或收货人，都需要说的第一句话是：");
        section2Info1.setAnswer1("你好，我来取货了");
        section2Info1.setAnswer2("你好，这里有份你的快递");
        section2Info1.setAnswer3("你好，我是人人快递网的自由快递人");

        Section2Info section2Info2 = new Section2Info();
        section2Info2.setNumber("1. 单选题");
        section2Info2.setQuestion("每次致电发货人或收货人，都需要说的第一句话是：");
        section2Info2.setAnswer1("你好，我来取货了");
        section2Info2.setAnswer2("你好，这里有份你的快递");
        section2Info2.setAnswer3("你好，我是人人快递网的自由快递人");

        Section2Info section2Info3 = new Section2Info();
        section2Info3.setNumber("1. 单选题");
        section2Info3.setQuestion("每次致电发货人或收货人，都需要说的第一句话是：");
        section2Info3.setAnswer1("你好，我来取货了");
        section2Info3.setAnswer2("你好，这里有份你的快递");
        section2Info3.setAnswer3("你好，我是人人快递网的自由快递人");

        Section2Info section2Info4 = new Section2Info();
        section2Info4.setNumber("1. 单选题");
        section2Info4.setQuestion("每次致电发货人或收货人，都需要说的第一句话是：");
        section2Info4.setAnswer1("你好，我来取货了");
        section2Info4.setAnswer2("你好，这里有份你的快递");
        section2Info4.setAnswer3("你好，我是人人快递网的自由快递人");

        mSection2Infos.add(section2Info1);
        mSection2Infos.add(section2Info2);
        mSection2Infos.add(section2Info3);
        mSection2Infos.add(section2Info4);
    }

    @Override
    public void onItemClick(int position) {

    }
}
