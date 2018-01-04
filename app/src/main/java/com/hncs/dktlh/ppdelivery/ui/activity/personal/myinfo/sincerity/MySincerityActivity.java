package com.hncs.dktlh.ppdelivery.ui.activity.personal.myinfo.sincerity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseActivity;

import butterknife.BindView;
import cn.share.jack.cygwidget.titlebar.TitleBarUIComponent;

public class MySincerityActivity extends BaseActivity {


    @BindView(R.id.expandlistview)
    ExpandableListView mExpandableListView;
    @BindView(R.id.titlebar)
    TitleBarUIComponent mBarUIComponent;

    //Model：定义的数据
    private String[] faqTitleList = {"A", "B", "C"};
    //注意，字符数组不要写成{{"A1,A2,A3,A4"}, {"B1,B2,B3,B4，B5"}, {"C1,C2,C3,C4"}}*/
    private String[][] contentList={{"A1","A2","A3","A4"},{"A1","A2","A3", "B4"},{"A1","A2","A3","C4"}};

    @Override
    protected int layoutRes() {
        return R.layout.activity_my_sincerity;
    }

    @Override
    protected void initView() {

        //初始化导航栏
        mBarUIComponent.initLeft(R.mipmap.ic_back_blue, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mBarUIComponent.initTitle(
                getResources().getString(R.string.my_sincerity),
                getResources().getColor(R.color.login_gray_45));
        mBarUIComponent.setRightTextColor(getResources().getColor(R.color.login_blue_1A));
        mBarUIComponent.initRight(
                getResources().getString(R.string.sincerity_rules),
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });

        //设置下拉列表
        MyAdapter adapter = new MyAdapter();
        mExpandableListView.setGroupIndicator(null);
        mExpandableListView.setAdapter(adapter);
        mExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                return true;
            }
        });

        //设置Group默认展开
        int groupCount = mExpandableListView.getCount();
        for (int i = 0; i < groupCount; i++) {
            mExpandableListView.expandGroup(i);
        }
    }

    /**
     * 自定义适配器
     */
    public class MyAdapter extends BaseExpandableListAdapter {

        //获取组元素数目
        @Override
        public int getGroupCount() {
            return faqTitleList.length;
        }

        //获取子元素数目
        @Override
        public int getChildrenCount(int i) {
            return contentList[i].length;
        }

        //获取组元素对象
        @Override
        public Object getGroup(int i) {
            return faqTitleList[i];
        }

        //获取子元素对象
        @Override
        public Object getChild(int i, int i1) {
            return contentList[i][i1];
        }

        //获取组元素id
        @Override
        public long getGroupId(int i) {
            return i;
        }

        //获取子元素Id
        @Override
        public long getChildId(int i, int i1) {
            return i1;
        }

        //每个item的id是否是固定？一般为true
        @Override
        public boolean hasStableIds() {
            return true;
        }

        //加载并显示组元素
        @Override
        public View getGroupView(int i, boolean b, View contverView, ViewGroup viewGroup) {
            GroupHolder groupHolder = null;
            if (contverView != null) {
                groupHolder = (GroupHolder) contverView.getTag();
            } else {
                contverView = View.inflate(MySincerityActivity.this, R.layout.item_group_sincerity, null);
                groupHolder = new GroupHolder(contverView);
                contverView.setTag(groupHolder);
            }
//            groupHolder.mTvFAQTitle.setText(faqTitleList[i]);
            return contverView;
        }

        //加载并显示子元素
        @Override
        public View getChildView(int i, int i1, boolean b, View contverView, ViewGroup viewGroup) {
            ChildHolder childHolder = null;
            if (contverView != null) {
                childHolder = (ChildHolder) contverView.getTag();
            } else {
                contverView = View.inflate(MySincerityActivity.this, R.layout.item_child_sincerity, null);
                childHolder = new ChildHolder(contverView);
                contverView.setTag(childHolder);
            }
            //判断如果是最后一行就进行显示
            if (i != faqTitleList.length - 1) {
                if (i1 == contentList[i].length - 1) {
                    childHolder.itemShort.setVisibility(View.GONE);
                    childHolder.itemLong.setVisibility(View.VISIBLE);
                } else {
                    childHolder.itemShort.setVisibility(View.VISIBLE);
                    childHolder.itemLong.setVisibility(View.GONE);
                }
            } else {
                childHolder.itemShort.setVisibility(View.VISIBLE);
                childHolder.itemLong.setVisibility(View.GONE);
            }
//            childHolder.mTvAnswerContent.setText(contentList[i][i1]);
            return contverView;
        }

        //二级列表中的item是否能够被选中？可以改为true
        @Override
        public boolean isChildSelectable(int i, int i1) {
            return true;
        }
    }

    static class GroupHolder {
        public GroupHolder(View view) {

        }
    }

    static class ChildHolder {

        View itemLong;
        View itemShort;

        public ChildHolder(View view) {
            itemLong = view.findViewById(R.id.item_long);
            itemShort = view.findViewById(R.id.item_short);
        }
    }
}
