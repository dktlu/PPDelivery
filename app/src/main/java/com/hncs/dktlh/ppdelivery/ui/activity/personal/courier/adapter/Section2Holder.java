package com.hncs.dktlh.ppdelivery.ui.activity.personal.courier.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.model.personal.courier.Section2Info;

import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerViewHolder;

/**
 * Created by dengkaitao on 2018/1/3 15:26.
 * Email：724279138@qq.com
 */

public class Section2Holder extends CygBaseRecyclerViewHolder<Section2Info> {

    TextView tvNo;
    TextView tvQuestion;
    RadioButton rbAnswer1;
    RadioButton rbAnswer2;
    RadioButton rbAnswer3;

    public Section2Holder(View view) {
        super(view);
        tvNo = view.findViewById(R.id.tv_no);
        tvQuestion = view.findViewById(R.id.tv_question);
        rbAnswer1 = view.findViewById(R.id.rb_answer1);
        rbAnswer2 = view.findViewById(R.id.rb_answer2);
        rbAnswer3 = view.findViewById(R.id.rb_answer3);
    }

    @Override
    protected void onItemDataUpdated(@Nullable Section2Info section2Info) {
        tvNo.setText(section2Info.getNumber());
        tvQuestion.setText(section2Info.getQuestion());
        rbAnswer1.setText(section2Info.getAnswer1());
        rbAnswer2.setText(section2Info.getAnswer2());
        rbAnswer3.setText(section2Info.getAnswer3());
    }
}
