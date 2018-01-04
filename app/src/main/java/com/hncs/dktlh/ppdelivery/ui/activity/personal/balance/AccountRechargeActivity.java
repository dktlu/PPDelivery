package com.hncs.dktlh.ppdelivery.ui.activity.personal.balance;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseActivity;
import com.hncs.dktlh.ppdelivery.ui.activity.main.goodsinfo.GoodsInfoActivity;
import com.hncs.dktlh.ppdelivery.ui.custom.flowlayout.AutoFlowLayout;
import com.hncs.dktlh.ppdelivery.ui.custom.flowlayout.FlowAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.share.jack.cygwidget.titlebar.TitleBarUIComponent;

public class AccountRechargeActivity extends BaseActivity {

    @BindView(R.id.titlebar)
    TitleBarUIComponent mBarUIComponent;
    @BindView(R.id.tag_layout)
    AutoFlowLayout tagLayout;

    private List<String> mList;//类别数据

    @Override
    protected int layoutRes() {
        return R.layout.activity_account_recharge;
    }

    @Override
    protected void initView() {

        mBarUIComponent.initTitle(getResources().getString(R.string.account_recharge),
                getResources().getColor(R.color.login_gray_45));
        mBarUIComponent.initLeft(R.mipmap.ic_back_blue, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mList = new ArrayList<>();
        String[] data = getResources().getStringArray(R.array.recharge_price);
        for (int i = 0; i < data.length; i++) {
            mList.add(data[i]);
        }

        tagLayout.setAdapter(new FlowAdapter(data) {
            @Override
            public View getView(int i) {
                View item = LayoutInflater.from(AccountRechargeActivity.this)
                        .inflate(R.layout.item_goods_info, null);
                TextView tvAttrTag = (TextView) item.findViewById(R.id.tv_classify);
                tvAttrTag.setText(data[i]);
                return item;
            }
        });
    }
}
