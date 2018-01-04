package com.hncs.dktlh.ppdelivery.ui.activity.personal.faq;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseActivity;

import butterknife.BindView;
import cn.share.jack.cygwidget.titlebar.TitleBarUIComponent;

/**
 * 常见问题界面
 */
public class FAQActivity extends BaseActivity {

    /**
     * 常见问题标题集合
     */
//    private List<String> faqTitleList = new ArrayList<>();
    /**
     * 问题解答内容集合
     */
//    private List<String> contentList = new ArrayList<>();
    //Model：定义的数据
    private String[] faqTitleList = {"Q1:人人快递是个怎样一个平台？",
            "Q1:人人快递是个怎样一个平台？", "Q1:人人快递是个怎样一个平台？"};
    private String[][] contentList={{"彼时，国家级贫困县卢氏，正因56年坚守土坯房县委大院受到媒体关注。被问及为何不盖新楼，王战方义正辞严，“如果民生问题不解决，我们的发展问题不解决，盖一栋办公楼又能解决得了什么？”"},
            {"彼时，国家级贫困县卢氏，正因56年坚守土坯房县委大院受到媒体关注。被问及为何不盖新楼，王战方义正辞严，“如果民生问题不解决，我们的发展问题不解决，盖一栋办公楼又能解决得了什么？”"},
                    {"彼时，国家级贫困县卢氏，正因56年坚守土坯房县委大院受到媒体关注。被问及为何不盖新楼，王战方义正辞严，“如果民生问题不解决，我们的发展问题不解决，盖一栋办公楼又能解决得了什么？”"}};

    @BindView(R.id.expandlistview)
    ExpandableListView mExpandableListView;
    @BindView(R.id.titlebar)
    TitleBarUIComponent mBarUIComponent;

    @Override
    protected int layoutRes() {
        return R.layout.activity_faq;
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
        mBarUIComponent.initTitle(getResources().getString(R.string.faq), getResources().getColor(R.color.login_gray_45));

        //设置下拉列表
        MyAdapter adapter = new MyAdapter();
        mExpandableListView.setGroupIndicator(null);
        mExpandableListView.setAdapter(adapter);

        //设置Group默认闭合
        int groupCount = mExpandableListView.getCount();
        for (int i = 0; i < groupCount; i++) {
            mExpandableListView.collapseGroup(i);
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
                contverView = View.inflate(FAQActivity.this, R.layout.list_faq_group, null);
                groupHolder = new GroupHolder(contverView);
                contverView.setTag(groupHolder);
            }
            groupHolder.mTvFAQTitle.setText(faqTitleList[i]);
            return contverView;
        }

        //加载并显示子元素
        @Override
        public View getChildView(int i, int i1, boolean b, View contverView, ViewGroup viewGroup) {
            ChildHolder childHolder = null;
            if (contverView != null) {
                childHolder = (ChildHolder) contverView.getTag();
            } else {
                contverView = View.inflate(FAQActivity.this, R.layout.list_faq_child, null);
                childHolder = new ChildHolder(contverView);
                contverView.setTag(childHolder);
            }
            //判断如果是最后一行就进行显示
            if (i != faqTitleList.length - 1) {
                if (i1 == contentList[i].length - 1) {
                    childHolder.itemDivider.setVisibility(View.VISIBLE);
                } else {
                    childHolder.itemDivider.setVisibility(View.GONE);
                }
            } else {
                childHolder.itemDivider.setVisibility(View.GONE);
            }
            childHolder.mTvAnswerContent.setText(contentList[i][i1]);
            return contverView;
        }

        //二级列表中的item是否能够被选中？可以改为true
        @Override
        public boolean isChildSelectable(int i, int i1) {
            return true;
        }
    }

    static class GroupHolder {
        TextView mTvFAQTitle;

        public GroupHolder(View view) {
            mTvFAQTitle = view.findViewById(R.id.tv_faq_title);
        }
    }

    static class ChildHolder {
        TextView mTvAnswerContent;
        View itemDivider;

        public ChildHolder(View view) {
            mTvAnswerContent = view.findViewById(R.id.tv_content);
            itemDivider = view.findViewById(R.id.item_divider);
        }
    }
}
