package com.hncs.dktlh.ppdelivery.ui.activity.personal;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseActivity;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.balance.AccountBalanceActivity;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.bill.DispatchActivity;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.bill.MyBillActivity;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.courier.ApplyCourierActivity;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.faq.FAQActivity;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.feedback.FeedbackActivity;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.insurance.InsuranceCoverActivity;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.myinfo.MyInfosActivity;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.setting.SettingActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class PersonalCenterActivity extends BaseActivity implements MyOneLineView.OnRootClickListener {

    @BindView(R.id.ll_root)
    LinearLayout llRoot;
    @BindView(R.id.iv_left_icon)
    ImageView ivLeftIcon;

    @Override
    protected int layoutRes() {
        return R.layout.activity_personal_center;
    }

    @Override
    protected void initView() {

        //代码添加我的发单行
        llRoot.addView(new MyOneLineView(this).initMine(R.mipmap.ic_personal_my_order,
                getResources().getString(R.string.my_order), "", true)
                .setDividerBottomMargin(15, 0, 0, 0)
                .setOnRootClickListener(this, 1));
        //我的派单
        llRoot.addView(new MyOneLineView(this).initMine(R.mipmap.ic_personal_my_send_single,
                getResources().getString(R.string.my_send_single), "", true)
                .setDividerBottomMargin(15, 0, 0, 0)
                .setOnRootClickListener(this, 2));
        //申请成为快递员
        llRoot.addView(new MyOneLineView(this).initMine(R.mipmap.ic_personal_apply_for_courier,
                getResources().getString(R.string.apply_for_courier), "", true)
                .setOnRootClickListener(this, 3));

        //上下2个区块的间隔
        addBackgroundColorDivider();
        //联系客服
        llRoot.addView(new MyOneLineView(this).initMine(R.mipmap.ic_personal_contact_customer_service,
                getResources().getString(R.string.contact_customer_service), "", true)
                .setDividerBottomMargin(15, 0, 0, 0)
                .setOnRootClickListener(this, 4));
        //常见问题
        llRoot.addView(new MyOneLineView(this).initMine(R.mipmap.ic_personal_faq,
                getResources().getString(R.string.faq), "", true)
                .setDividerBottomMargin(15, 0, 0, 0)
                .setOnRootClickListener(this, 5));
        //设置
        llRoot.addView(new MyOneLineView(this).initMine(R.mipmap.ic_personal_setting,
                getResources().getString(R.string.setting), "", true)
                .setOnRootClickListener(this, 6));

        //上下2个区块的间隔
        addBackgroundColorDivider();
        //我的投保险
        llRoot.addView(new MyOneLineView(this).initMine(R.mipmap.ic_personal_my_insurance,
                getResources().getString(R.string.my_insurance), "", true)
                .setDividerBottomMargin(15, 0, 0, 0)
                .setOnRootClickListener(this, 7));
        //聊天
        llRoot.addView(new MyOneLineView(this).initMine(R.mipmap.ic_personal_chat,
                getResources().getString(R.string.chat), "", true)
                .setDividerBottomMargin(15, 0, 0, 0)
                .setOnRootClickListener(this, 8));
        //意见反馈
        llRoot.addView(new MyOneLineView(this).initMine(R.mipmap.ic_personal_feedback,
                getResources().getString(R.string.feedback), "", true)
                .setOnRootClickListener(this, 9));
    }

    private void addBackgroundColorDivider() {
        View view = new View(this);
        ViewGroup.LayoutParams layoutParams =
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 20);
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(getResources().getColor(R.color.background));
        llRoot.addView(view);
    }

    @OnClick({R.id.iv_left_icon, R.id.ll_my_Balance})
    void onClickView(View view) {
        switch (view.getId()) {
            case R.id.iv_left_icon:
                finish();
                break;
            case R.id.ll_my_Balance:
                startActivity(new Intent(this, AccountBalanceActivity.class));
                break;
        }
    }

    @OnClick({R.id.img_person_head, R.id.tv_phone, R.id.iv_level})
    void onClickedMyInfos(View view) {
        startActivity(new Intent(this, MyInfosActivity.class));
    }

    @Override
    public void onRootClick(View view) {
        switch ((Integer) view.getTag()) {
            case 1://我的发单
                startActivity(new Intent(this, MyBillActivity.class));
                break;
            case 2://我的派单
                startActivity(new Intent(this, DispatchActivity.class));
                break;
            case 3://申请成为快递员
                startActivity(new Intent(this, ApplyCourierActivity.class));
                break;
            case 4:

                break;
            case 5://常见问题
                startActivity(new Intent(this, FAQActivity.class));
                break;
            case 6://设置
                startActivity(new Intent(this, SettingActivity.class));
                break;
            case 7://我的投保险
                startActivity(new Intent(this, InsuranceCoverActivity.class));
                break;
            case 8:

                break;
            case 9:
                startActivity(new Intent(this, FeedbackActivity.class));
                break;
        }
    }
}
