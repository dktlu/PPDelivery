package com.hncs.dktlh.ppdelivery.ui.activity.main.message;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseActivity;
import com.hncs.dktlh.ppdelivery.ui.activity.main.adapter.message.SystemMessageAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.share.jack.cygwidget.recyclerview.PtrRecyclerViewUIComponent;
import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerAdapter;
import cn.share.jack.cygwidget.titlebar.TitleBarUIComponent;

/**
 * 系统消息界面
 */
public class SystemMessageActivity extends BaseActivity implements CygBaseRecyclerAdapter.OnItemClickListener {

    @BindView(R.id.titlebar)
    TitleBarUIComponent mBarUIComponent;
    @BindView(R.id.am_ptr_framelayout)
    PtrRecyclerViewUIComponent ptrRecyclerViewUIComponent;

    private SystemMessageAdapter mAdapter;
    private List<String> mList;

    @Override
    protected int layoutRes() {
        return R.layout.activity_system_message;
    }

    @Override
    protected void initView() {

        mBarUIComponent.initTitle(getResources().getString(R.string.txt_system_message),
                getResources().getColor(R.color.login_gray_45));
        mBarUIComponent.initLeft(R.mipmap.ic_back_blue, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mList = new ArrayList<>();
        mList.add("1");
        mList.add("2");
        mList.add("3");

        mAdapter = new SystemMessageAdapter(this, this);
        ptrRecyclerViewUIComponent.setLayoutManager(new LinearLayoutManager(this));
        ptrRecyclerViewUIComponent.setCanRefresh(false);
        ptrRecyclerViewUIComponent.setAdapter(mAdapter);
        mAdapter.setDataList(mList);
    }

    @Override
    public void onItemClick(int position) {

    }
}
