package com.hncs.dktlh.ppdelivery.ui.activity.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class Main1Activity extends BaseActivity {

    //声明ViewPager
    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    //适配器
    private FragmentPagerAdapter mAdapter;

    //装载fragment的集合
    private List<Fragment> mFragments;

    @BindView(R.id.id_bottom_tab1)
    LinearLayout idBottomTab1;
    @BindView(R.id.id_bottom_tab2)
    LinearLayout idBottomTab2;
    @BindView(R.id.id_bottom_tab3)
    LinearLayout idBottomTab3;
    @BindView(R.id.tv_first)
    TextView tvFirst;
    @BindView(R.id.tv_second)
    TextView tvSecond;
    @BindView(R.id.tv_three)
    TextView tvThree;

    @Override
    protected int layoutRes() {
        return R.layout.activity_main1;
    }

    @Override
    protected void initView() {

        mFragments = new ArrayList<>();
        //将3个Fragment加入集合中
        mFragments.add(new FirstFragment());
        mFragments.add(new SecondFragment());
        mFragments.add(new ThreeFragment());

        //初始化适配器
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                //从集合中获取对应位置的Fragment
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                //获取结合中Fragment的总数
                return mFragments.size();
            }
        };
        mViewPager.setAdapter(mAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //设置Position对应的集合中的Fragment
                mViewPager.setCurrentItem(position);
                resetImgs();
                selectTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick({R.id.id_bottom_tab1, R.id.id_bottom_tab2, R.id.id_bottom_tab3})
    public void onViewClicked(View view) {

        //将底部样式设置为默认状态
        resetImgs();
        switch (view.getId()) {
            case R.id.id_bottom_tab1:
                selectTab(0);
                break;
            case R.id.id_bottom_tab2:
                selectTab(1);
                break;
            case R.id.id_bottom_tab3:
                selectTab(2);
                break;
        }
    }

    private void selectTab(int i) {
        //根据点击的Tab设置对应的ImageView图片
        switch (i) {
            case 0:
                tvFirst.setTextColor(getResources().getColor(R.color.colorAccent));
//                mImgWeixin.setImageResource(R.mipmap.tab_weixin_pressed);
                break;
            case 1:
                tvSecond.setTextColor(getResources().getColor(R.color.colorAccent));
//                mImgFrd.setImageResource(R.mipmap.tab_find_frd_pressed);
                break;
            case 2:
                tvThree.setTextColor(getResources().getColor(R.color.colorAccent));
//                mImgAddress.setImageResource(R.mipmap.tab_address_pressed);
                break;
        }
        //设置当前点击的Tab所对应的页面
        mViewPager.setCurrentItem(i);
    }

    //将四个ImageView设置为灰色
    private void resetImgs() {
        tvFirst.setTextColor(getResources().getColor(R.color.gray_333));
        tvSecond.setTextColor(getResources().getColor(R.color.gray_333));
        tvThree.setTextColor(getResources().getColor(R.color.gray_333));
//        mImgWeixin.setImageResource(R.mipmap.tab_weixin_normal);
//        mImgFrd.setImageResource(R.mipmap.tab_find_frd_normal);
//        mImgAddress.setImageResource(R.mipmap.tab_address_normal);
    }
}
