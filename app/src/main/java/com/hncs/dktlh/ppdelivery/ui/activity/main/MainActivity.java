package com.hncs.dktlh.ppdelivery.ui.activity.main;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.widget.LinearLayoutManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.eggsy.rxbus.RxBus;
import com.eggsy.rxbus.ThreadMode;
import com.eggsy.rxbus.annotation.EventSubscribe;
import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseActivity;
import com.hncs.dktlh.ppdelivery.ui.custom.OverlyingRoundLayout;
import com.hncs.dktlh.ppdelivery.ui.custom.Pickers;
import com.hncs.dktlh.ppdelivery.ui.dialog.DistributionModeDialog;
import com.hncs.dktlh.ppdelivery.ui.dialog.IncreasePriceDialog;
import com.hncs.dktlh.ppdelivery.ui.dialog.PickTimeDialog;
import com.hncs.dktlh.ppdelivery.ui.activity.main.adapter.NearbyAdapter;
import com.hncs.dktlh.ppdelivery.ui.activity.main.adapter.NearbyHolder;
import com.hncs.dktlh.ppdelivery.ui.activity.main.goodsinfo.GoodsInfoActivity;
import com.hncs.dktlh.ppdelivery.ui.activity.main.message.MessageCenterActivity;
import com.hncs.dktlh.ppdelivery.ui.activity.main.order.SureOrderActivity;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.MyOneLineView;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.PersonalCenterActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.share.jack.cygwidget.recyclerview.PtrRecyclerViewUIComponent;
import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerAdapter;

/**
 * 主页
 * Created by dengkaitao on 2017/12/23 10:24.
 * Email：724279138@qq.com
 */

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener,
        CygBaseRecyclerAdapter.OnItemClickListener<NearbyHolder>, MyOneLineView.OnRootClickListener {

    @BindView(R.id.iv_personal)
    ImageView ivPersonal;
    @BindView(R.id.rl_msg)
    RelativeLayout rlMsg;
    @BindView(R.id.ll_root)
    LinearLayout llRoot;
    @BindView(R.id.am_ptr_framelayout)
    PtrRecyclerViewUIComponent mPtrRecyclerViewUIComponent;
    @BindView(R.id.ll_nearby)
    OverlyingRoundLayout llNearby;

    private NearbyAdapter mAdapter;
    private List<String> datas;

    //记录第一次点击时间
    private long clickTime = 0;

    private MyOneLineView deliveryModeView;
    private MyOneLineView pickUpGoodsTimeView;
    private MyOneLineView latestArrivalTimeView;
    private MyOneLineView goodsInfoView;

    private int[] imgs = {
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher
    };

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

//        mSubscription = RxBus.get().toFlowable(Pickers.class)
//                .subscribe(new Action1<Pickers>() {
//
//                });

        llNearby.setImageSource(imgs);
        llNearby.initDatas();

        //发快递
        MyOneLineView sendItemView = new MyOneLineView(this);
        sendItemView.initItemWidthEdit(
                R.mipmap.ic_index_send_express, "",
                getResources().getString(R.string.hint_consignor_address));
        sendItemView.setIvRightIcon(R.mipmap.ic_index_right_arrow);
        sendItemView.setEditColor(R.color.login_gray_c8);
        sendItemView.setEditMargin(10, 0, 10, 0);
        sendItemView.setDividerBottomMargin(45, 0, 0, 0);
        sendItemView.showArrow(true);
        sendItemView.showTextContent(false);
        sendItemView.showDivider(true, true);
        llRoot.addView(sendItemView);

        //收快递
        MyOneLineView collectItemView = new MyOneLineView(this);
        collectItemView.initItemWidthEdit(
                R.mipmap.ic_index_collect_express, "",
                getResources().getString(R.string.hint_consignee_address));
        collectItemView.setIvRightIcon(R.mipmap.ic_index_right_arrow);
        collectItemView.setEditColor(R.color.login_gray_c8);
        collectItemView.setEditMargin(10, 0, 10, 0);
        collectItemView.showArrow(true);
        collectItemView.showTextContent(false);
        collectItemView.showDivider(false, true);
        llRoot.addView(collectItemView);

        View view = new View(this);
        ViewGroup.LayoutParams layoutParams =
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 11);
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(getResources().getColor(R.color.background));
        llRoot.addView(view);

        //取货时间
        pickUpGoodsTimeView = new MyOneLineView(this);
        pickUpGoodsTimeView.initMine(R.mipmap.ic_back_blue, getResources().getString(R.string.pickup_goods_time), "请选择", true);
        pickUpGoodsTimeView.showLeftIcon(false);
        pickUpGoodsTimeView.setIvRightIcon(R.mipmap.ic_index_right_arrow);
        pickUpGoodsTimeView.showDivider(true, true);
        pickUpGoodsTimeView.setTextContentMargin(0, 0, 0, 0);
        pickUpGoodsTimeView.setDividerBottomMargin(14, 0, 0, 0);
        pickUpGoodsTimeView.setOnRootClickListener(this, 2);
        llRoot.addView(pickUpGoodsTimeView);

        //最晚到达时间
        latestArrivalTimeView = new MyOneLineView(this);
        latestArrivalTimeView.initMine(R.mipmap.ic_back_blue, getResources().getString(R.string.latest_arrival_time), "请选择", true);
        latestArrivalTimeView.showLeftIcon(false);
        latestArrivalTimeView.setIvRightIcon(R.mipmap.ic_index_right_arrow);
        latestArrivalTimeView.showDivider(false, true);
        latestArrivalTimeView.setTextContentMargin(0, 0, 0, 0);
        latestArrivalTimeView.setDividerBottomMargin(14, 0, 0, 0);
        latestArrivalTimeView.setOnRootClickListener(this, 3);
        llRoot.addView(latestArrivalTimeView);

        //物品信息
        goodsInfoView = new MyOneLineView(this);
        goodsInfoView.initMine(R.mipmap.ic_back_blue, getResources().getString(R.string.goods_info), "请选择", true);
        goodsInfoView.showLeftIcon(false);
        goodsInfoView.setIvRightIcon(R.mipmap.ic_index_right_arrow);
        goodsInfoView.showDivider(false, true);
        goodsInfoView.setTextContentMargin(0, 0, 0, 0);
        goodsInfoView.setDividerBottomMargin(14, 0, 0, 0);
        goodsInfoView.setOnRootClickListener(this, 4);
        llRoot.addView(goodsInfoView);

        //送货方式
        deliveryModeView = new MyOneLineView(this);
        deliveryModeView.initMine(R.mipmap.ic_back_blue, getResources().getString(R.string.delivery_mode), "请选择", true);
        deliveryModeView.showLeftIcon(false);
        deliveryModeView.setIvRightIcon(R.mipmap.ic_index_right_arrow);
        deliveryModeView.showDivider(false, true);
        deliveryModeView.setTextContentMargin(0, 0, 0, 0);
        deliveryModeView.setOnRootClickListener(this, 5);
        llRoot.addView(deliveryModeView);

        datas = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            datas.add("i" + i);
        }

        mAdapter = new NearbyAdapter(this, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mPtrRecyclerViewUIComponent.setLayoutManager(layoutManager);
        mPtrRecyclerViewUIComponent.setCanRefresh(false);
        mPtrRecyclerViewUIComponent.setAdapter(mAdapter);
        mAdapter.setDataList(datas);

        RxBus.register(this);
    }

    @EventSubscribe(tmode = ThreadMode.MainThread)
    public void updateDistributionMode(Pickers pickers) {
        deliveryModeView.setRightText(pickers.getShowContent());
    }

    @EventSubscribe(tmode = ThreadMode.MainThread)
    public void updateGoodsInfo(String s) {
        goodsInfoView.setRightText(s);
    }

    @OnClick({R.id.iv_personal, R.id.iv_msg, R.id.tv_display_pricing_rules, R.id.rl_msg,
    R.id.tv_increase_price, R.id.tv_place_an_order})
    void onClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_personal:
                startActivity(new Intent(this, PersonalCenterActivity.class));
                break;
            case R.id.tv_display_pricing_rules://查看计价规则
                startActivity(new Intent(this, PricingRulesActivity.class));
                break;
            case R.id.iv_msg:
            case R.id.rl_msg:
                startActivity(new Intent(this, MessageCenterActivity.class));
                break;
            case R.id.tv_increase_price:
                IncreasePriceDialog priceDialog = new IncreasePriceDialog(this);
                priceDialog.show();
                break;
            case R.id.tv_place_an_order://去下单
                startActivity(new Intent(this, SureOrderActivity.class));
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if ((System.currentTimeMillis() - clickTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次后退键退出程序",
                    Toast.LENGTH_SHORT).show();
            clickTime = System.currentTimeMillis();
        } else {
            this.finish();
            //     System.exit(0);
        }
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onRootClick(View view) {
        switch ((Integer) view.getTag()) {
            case 2:
                PickTimeDialog pickTimeDialog = new PickTimeDialog(this);
                pickTimeDialog.setTitle(R.string.pickup_goods_time);
                pickTimeDialog.setOnClickListener(new PickTimeDialog.OnClickListener() {
                    @Override
                    public void onClick(View view, String s) {
                        pickUpGoodsTimeView.setRightText(s);
                    }
                });
                pickTimeDialog.show();
                break;
            case 3:
                PickTimeDialog latestTimeDialog = new PickTimeDialog(this);
                latestTimeDialog.setTitle(R.string.latest_arrival_time);
                latestTimeDialog.setOnClickListener(new PickTimeDialog.OnClickListener() {
                    @Override
                    public void onClick(View view, String s) {
                        latestArrivalTimeView.setRightText(s);
                    }
                });
                latestTimeDialog.show();
                break;
            case 4:
                startActivity(new Intent(MainActivity.this, GoodsInfoActivity.class));
                break;
            case 5:
                DistributionModeDialog distributionModeDialog = new DistributionModeDialog(this);
                distributionModeDialog.show();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.unRegister(this);
    }
}
