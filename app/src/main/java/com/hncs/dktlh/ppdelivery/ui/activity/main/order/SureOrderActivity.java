package com.hncs.dktlh.ppdelivery.ui.activity.main.order;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseActivity;
import com.hncs.dktlh.ppdelivery.ui.dialog.PayModeDialog;
import com.hncs.dktlh.ppdelivery.ui.dialog.PayPwdDialog;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.MyOneLineView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.share.jack.cygwidget.titlebar.TitleBarUIComponent;

/**
 * 确认订单界面
 */
public class SureOrderActivity extends BaseActivity {

    @BindView(R.id.titlebar)
    TitleBarUIComponent mBarUIComponent;
    @BindView(R.id.ll_root)
    LinearLayout llRoot;

    /**
     * 发货地址
     */
    private MyOneLineView deliveryItem;
    /**
     * 收获地址
     */
    private MyOneLineView receivingItem;
    /**
     * 取货时间
     */
    private MyOneLineView takeTimeItem;
    /**
     * 最后到达时间
     */
    private MyOneLineView latestTimeItem;
    /**
     * 物品类型
     */
    private MyOneLineView goodsModeItem;
    /**
     * 跑腿费
     */
    private MyOneLineView runningItem;
    /**
     * 加小费
     */
    private MyOneLineView addTipsItem;
    /**
     * 优惠券
     */
    private MyOneLineView couponsItem;
    /**
     * 备注说明
     */
    private MyOneLineView remarksItem;

    @Override
    protected int layoutRes() {
        return R.layout.activity_sure_order;
    }

    @Override
    protected void initView() {

        initBar();

        //发货地址
        deliveryItem = new MyOneLineView(this);
        deliveryItem.initMine(R.drawable.shape_red_dot,
                getResources().getString(R.string.delivery_address), "", true);
        deliveryItem.setLeftIconSize(4, 4);
        deliveryItem.setIvRightIcon(R.mipmap.ic_index_right_arrow);
        deliveryItem.setDividerBottomMargin(15, 0, 0, 0);
        deliveryItem.showDivider(false, true);
        llRoot.addView(deliveryItem);

        //发货地址
        receivingItem = new MyOneLineView(this);
        receivingItem.initMine(R.drawable.shape_blue_dot,
                getResources().getString(R.string.receiving_address), "", true);
        receivingItem.setLeftIconSize(4, 4);
        receivingItem.setIvRightIcon(R.mipmap.ic_index_right_arrow);
        receivingItem.showDivider(false, true);
        llRoot.addView(receivingItem);

        addBackgroundColorDivider();

        //取货时间
        takeTimeItem = new MyOneLineView(this);
        takeTimeItem.initMine(-1, getResources().getString(R.string.pickup_goods_time), "", true);
        takeTimeItem.setIvRightIcon(R.mipmap.ic_index_right_arrow);
        takeTimeItem.showLeftIcon(false);
        takeTimeItem.setDividerBottomMargin(15, 0, 0, 0);
        takeTimeItem.showDivider(true, true);
        takeTimeItem.setTextContentMargin(0, 0, 0, 0);
        llRoot.addView(takeTimeItem);

        //最晚到达时间
        latestTimeItem = new MyOneLineView(this);
        latestTimeItem.initMine(-1, getResources().getString(R.string.latest_arrival_time), "", true);
        latestTimeItem.setIvRightIcon(R.mipmap.ic_index_right_arrow);
        latestTimeItem.showLeftIcon(false);
        latestTimeItem.setDividerBottomMargin(15, 0, 0, 0);
        latestTimeItem.showDivider(false, true);
        latestTimeItem.setTextContentMargin(0, 0, 0, 0);
        llRoot.addView(latestTimeItem);

        //物品类型
        goodsModeItem = new MyOneLineView(this);
        goodsModeItem.initMine(-1, getResources().getString(R.string.goods_mode), "", true);
        goodsModeItem.setIvRightIcon(R.mipmap.ic_index_right_arrow);
        goodsModeItem.showLeftIcon(false);
        goodsModeItem.showDivider(false, true);
        goodsModeItem.setTextContentMargin(0, 0, 0, 0);
        llRoot.addView(goodsModeItem);

        addBackgroundColorDivider();

        //跑腿费
        runningItem = new MyOneLineView(this);
        runningItem.initMine(-1, getResources().getString(R.string.running_leg_fee), "", true);
        runningItem.setIvRightIcon(R.mipmap.ic_index_right_arrow);
        runningItem.showLeftIcon(false);
        runningItem.setDividerBottomMargin(15, 0, 0, 0);
        runningItem.showDivider(true, true);
        runningItem.setTextContentMargin(0, 0, 0, 0);
        llRoot.addView(runningItem);

        //加小费
        addTipsItem = new MyOneLineView(this);
        addTipsItem.initMine(-1, getResources().getString(R.string.add_tips), "", true);
        addTipsItem.setIvRightIcon(R.mipmap.ic_index_right_arrow);
        addTipsItem.showLeftIcon(false);
        addTipsItem.setDividerBottomMargin(15, 0, 0, 0);
        addTipsItem.showDivider(false, true);
        addTipsItem.setTextContentMargin(0, 0, 0, 0);
        llRoot.addView(addTipsItem);

        //优惠券
        couponsItem = new MyOneLineView(this);
        couponsItem.initMine(-1, getResources().getString(R.string.coupons), "", true);
        couponsItem.setIvRightIcon(R.mipmap.ic_index_right_arrow);
        couponsItem.showLeftIcon(false);
        couponsItem.showDivider(false, true);
        couponsItem.setTextContentMargin(0, 0, 0, 0);
        llRoot.addView(couponsItem);

        addBackgroundColorDivider();

        //备注说明
        receivingItem = new MyOneLineView(this);
        receivingItem.initItemWidthEdit(-1,
                getResources().getString(R.string.remarks),
                getResources().getString(R.string.hint_remarks));
        receivingItem.showLeftIcon(false);
        receivingItem.showDivider(true, true);
        receivingItem.setTextContentMargin(0, 0, 0, 0);
        receivingItem.setEditMargin(15, 0, 15, 0);
        receivingItem.setEditHintColor(R.color.pricing_rules_9c);
    }

    private void addBackgroundColorDivider() {
        View view = new View(this);
        ViewGroup.LayoutParams layoutParams =
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 20);
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(getResources().getColor(R.color.background));
        llRoot.addView(view);
    }

    private void initBar() {
        mBarUIComponent.initTitle(getResources().getString(R.string.sure_order),
                getResources().getColor(R.color.login_gray_45));
        mBarUIComponent.initLeft(R.mipmap.ic_back_blue, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mBarUIComponent.initRight(getResources().getString(R.string.certification),
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(SureOrderActivity.this, CertificationActivity.class));
                    }
                });
        mBarUIComponent.setRightTextColor(R.color.login_blue_1A);
    }

    @OnClick({R.id.tv_go_pay})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_go_pay:
                PayModeDialog payModeDialog = new PayModeDialog(this);
                payModeDialog.setOnClickListener(new PayModeDialog.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PayPwdDialog payPwdDialog = new PayPwdDialog(SureOrderActivity.this);
                        payPwdDialog.setGravity(Gravity.CENTER);
                        payPwdDialog.show();
                    }
                });
                payModeDialog.show();
                break;
        }
    }
}
