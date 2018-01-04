package com.hncs.dktlh.ppdelivery.ui.activity.personal.balance.drawbill;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.share.jack.cygwidget.titlebar.TitleBarUIComponent;

/**
 * 开发票
 */
public class DrawBillActivity extends BaseActivity {

    @BindView(R.id.titlebar)
    TitleBarUIComponent mTitleBarUIComponent;
    @BindView(R.id.tabs)
    TabLayout mTabLayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    /**
     * 标题的集合
     */
    private List<String> mTitleList = new ArrayList<>();
    /**
     * 页卡视图
     */
    private CanDrawBillFragment mCanDrawBillFragment;
    private HistoryDrawBillFragment mHistoryDrawBillFragment;

    /**
     * 页卡视图集合
     */
    private List<Fragment> mFragmentList = new ArrayList<>();

    @Override
    protected int layoutRes() {
        return R.layout.activity_draw_bill;
    }

    @Override
    protected void initView() {
        mTitleBarUIComponent.initTitle(
                getResources().getString(R.string.draw_bill),
                R.color.help_send_order_tab_txt);
        mTitleBarUIComponent.initLeft(R.mipmap.ic_back_blue, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //添加页卡标题
        mTitleList.add(getResources().getString(R.string.can_draw_bill_order));
        mTitleList.add(getResources().getString(R.string.history_draw_bill));

        mCanDrawBillFragment = new CanDrawBillFragment();
        mHistoryDrawBillFragment = new HistoryDrawBillFragment();
        mFragmentList.add(mCanDrawBillFragment);
        mFragmentList.add(mHistoryDrawBillFragment);

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        //添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(0)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(1)));

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), mFragmentList);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(adapter);

    }

    //ViewPager的适配器
    public class MyPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> mList;

        public MyPagerAdapter(FragmentManager fm, List<Fragment> mList) {
            super(fm);
            this.mList = mList;
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Fragment getItem(int position) {
            return mList.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleList.get(position);//页卡标题
        }
    }

}
