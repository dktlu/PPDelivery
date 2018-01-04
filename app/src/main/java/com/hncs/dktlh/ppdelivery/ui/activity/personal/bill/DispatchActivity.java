package com.hncs.dktlh.ppdelivery.ui.activity.personal.bill;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseActivity;
import com.hncs.dktlh.ppdelivery.ui.dialog.OrderStatusDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.share.jack.cygwidget.titlebar.TitleBarUIComponent;

/**
 * 我的送货订单
 */
public class DispatchActivity extends BaseActivity {

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
    private TheCityFragment mTheCityFragment;
    private OtherCityFragment mOtherCityFragment;
    /**
     * 页卡视图集合
     */
    private List<Fragment> mFragmentList = new ArrayList<>();

    @Override
    protected int layoutRes() {
        return R.layout.activity_dispatch;
    }

    @Override
    protected void initView() {

        mTitleBarUIComponent.initTitle(
                getResources().getString(R.string.my_dispatch_order),
                R.color.help_send_order_tab_txt);
        mTitleBarUIComponent.initLeft(R.mipmap.ic_back_blue, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mTitleBarUIComponent.initRight(R.mipmap.ic_blue_more, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OrderStatusDialog statusDialog = new OrderStatusDialog(DispatchActivity.this);
                statusDialog.show();
            }
        });

        //添加页卡标题
        mTitleList.add(getResources().getString(R.string.the_city));
        mTitleList.add(getResources().getString(R.string.other_city));

        mTheCityFragment = new TheCityFragment();
        mOtherCityFragment = new OtherCityFragment();
        mFragmentList.add(mTheCityFragment);
        mFragmentList.add(mOtherCityFragment);

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
