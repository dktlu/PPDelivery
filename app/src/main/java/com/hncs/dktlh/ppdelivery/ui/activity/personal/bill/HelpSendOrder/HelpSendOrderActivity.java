package com.hncs.dktlh.ppdelivery.ui.activity.personal.bill.HelpSendOrder;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.share.jack.cygwidget.titlebar.TitleBarUIComponent;

public class HelpSendOrderActivity extends BaseActivity {

    @BindView(R.id.titlebar)
    TitleBarUIComponent mTitleBarUIComponent;
    @BindView(R.id.tabs)
    TabLayout mTabLayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    private LayoutInflater mInflater;
    /**
     * 标题的集合
     */
    private List<String> mTitleList = new ArrayList<>();
    /**
     * 页卡视图
     */
    private OrderStatusFragment mStatusFragment, mStatusFragment2, mStatusFragment3;
    /**
     * 页卡视图集合
     */
    private List<Fragment> mFragmentList = new ArrayList<>();


    @Override
    protected int layoutRes() {
        return R.layout.activity_help_send_order;
    }

    @Override
    protected void initView() {

        mTitleBarUIComponent.initTitle(
                getResources().getString(R.string.help_send_order),
                R.color.help_send_order_tab_txt);
        mTitleBarUIComponent.initLeft(R.mipmap.ic_back_blue, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mTitleBarUIComponent.initRight(getResources().getString(R.string.cancel_order),
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });

        //添加页卡标题
        mTitleList.add(getResources().getString(R.string.order_status));
        mTitleList.add(getResources().getString(R.string.trajectory_tracking));
        mTitleList.add(getResources().getString(R.string.order_detail));

        mStatusFragment = new OrderStatusFragment();
        mStatusFragment2 = new OrderStatusFragment();
        mStatusFragment3 = new OrderStatusFragment();

        //添加页卡视图
        mFragmentList.add(mStatusFragment);
        mFragmentList.add(mStatusFragment2);
        mFragmentList.add(mStatusFragment3);

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        //添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(0)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(2)));

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
