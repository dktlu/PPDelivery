package com.hncs.dktlh.ppdelivery.ui.activity.main.goodsinfo;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.eggsy.rxbus.RxBus;
import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseActivity;
import com.hncs.dktlh.ppdelivery.ui.custom.camera.NinePhotoView;
import com.hncs.dktlh.ppdelivery.ui.custom.flowlayout.AutoFlowLayout;
import com.hncs.dktlh.ppdelivery.ui.custom.flowlayout.FlowAdapter;
import com.hncs.dktlh.ppdelivery.ui.dialog.DistributionToolsDialog;
import com.hncs.dktlh.ppdelivery.ui.dialog.EditValueDialog;
import com.hncs.dktlh.ppdelivery.ui.activity.main.adapter.goodsinfo.GoodsInfoHolder;
import com.hncs.dktlh.ppdelivery.ui.activity.personal.MyOneLineView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerAdapter;
import cn.share.jack.cygwidget.titlebar.TitleBarUIComponent;

public class GoodsInfoActivity extends BaseActivity implements
        CygBaseRecyclerAdapter.OnItemClickListener<GoodsInfoHolder>,
        MyOneLineView.OnRootClickListener
//        ,
//        TakePhoto.TakeResultListener,
//        InvokeListener
{

    @BindView(R.id.titlebar)
    TitleBarUIComponent titleBar;
    @BindView(R.id.ll_root)
    LinearLayout llRoot;
    @BindView(R.id.tag_layout)
    AutoFlowLayout tagLayout;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.nine_photo_view)
    NinePhotoView mNinePhotoView;

    private List<String> mList;//类别数据
    private MyOneLineView weightItem;
    private MyOneLineView valueItem;
    private MyOneLineView toolItem;

    private String goodsMode;
    private String goodsWeight;
    private String goodsValue;

//    private TakePhoto takePhoto;
//    private InvokeParam invokeParam;
//    private CompressConfig compressConfig;  //压缩参数
//    private Uri imageUri;  //图片保存路径

    @Override
    protected int layoutRes() {
        return R.layout.activity_goods_info;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getTakePhoto().onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
//        getTakePhoto().onSaveInstanceState(outState);
    }

    @Override
    protected void initView() {
        initBar();

        mList = new ArrayList<>();
        String[] data = getResources().getStringArray(R.array.goodsinfo_classify);
        for (int i = 0; i < data.length; i++) {
            mList.add(data[i]);
        }
        tagLayout.setAdapter(new FlowAdapter(data) {
            @Override
            public View getView(int i) {
                View item = LayoutInflater.from(GoodsInfoActivity.this)
                        .inflate(R.layout.item_goods_info, null);
                TextView tvAttrTag = (TextView) item.findViewById(R.id.tv_classify);
                tvAttrTag.setText(data[i]);
                return item;
            }
        });

        tagLayout.setOnItemClickListener(new AutoFlowLayout.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                goodsMode = data[position];
            }
        });

        //设置压缩参数
//        compressConfig=new CompressConfig.Builder().setMaxSize(50*1024).setMaxPixel(800).create();
//        takePhoto.onEnableCompress(compressConfig,true);  //设置为需要压缩
        mNinePhotoView.setAddPhotoResId(R.mipmap.ic_photo);
        mNinePhotoView.setOnAddClickListener(new NinePhotoView.OnAddClickListener() {
            @Override
            public void onClick(View view) {
//                new SelectPhotoDialog(GoodsInfoActivity.this).show();
//                imageUri = FileUtils.getImageCropUri();
//                takePhoto.onPickFromCapture(imageUri);
            }
        });

        //物品重量
        weightItem = new MyOneLineView(this);
        weightItem.initMine(-1,
                getResources().getString(R.string.weight_goods),
                getResources().getString(R.string.please_selected), true);
        weightItem.setIvRightIcon(R.mipmap.ic_index_right_arrow);
        weightItem.setDividerBottomMargin(14, 0, 0, 0);
        weightItem.showLeftIcon(false);
        weightItem.showDivider(true, true);
        weightItem.setOnRootClickListener(this, 0);
        llRoot.addView(weightItem);

        //物品价值
        valueItem = new MyOneLineView(this);
        valueItem.initMine(-1,
                getResources().getString(R.string.googds_value),
                getResources().getString(R.string.please_selected), true);
        valueItem.setIvRightIcon(R.mipmap.ic_index_right_arrow);
        valueItem.showLeftIcon(false);
        valueItem.showDivider(false, true);
        valueItem.setOnRootClickListener(this, 1);
        llRoot.addView(valueItem);

        View view = new View(this);
        ViewGroup.LayoutParams layoutParams =
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 11);
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(getResources().getColor(R.color.background));
        llRoot.addView(view);

        //配送工具
        toolItem = new MyOneLineView(this);
        toolItem.initMine(-1,
                getResources().getString(R.string.distribution_tools),
                getResources().getString(R.string.please_selected), true);
        toolItem.setIvRightIcon(R.mipmap.ic_index_right_arrow);
        toolItem.showLeftIcon(false);
        toolItem.showDivider(true, true);
        toolItem.setOnRootClickListener(this, 2);
        llRoot.addView(toolItem);
    }

    /**
     * 初始化bar
     */
    private void initBar() {
        titleBar.initTitle(getResources().getString(R.string.goods_info),
                getResources().getColor(R.color.login_gray_45));
        titleBar.initLeft(R.mipmap.ic_back_blue, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        titleBar.setRightTextColor(getResources().getColor(R.color.login_blue_1A));
        titleBar.initRight(getResources().getString(R.string.sure), new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RxBus.post(goodsMode + " " + goodsWeight + " " + goodsValue);
                finish();
            }
        });
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onRootClick(View view) {
        switch ((Integer) view.getTag()) {
            case 0://物品重量
                EditValueDialog weightDialog = new EditValueDialog(this);
                weightDialog.setTitle(R.string.weight_goods);
                weightDialog.setEditHint(R.string.hint_input_weight);
                weightDialog.setUnit(R.string.weight_jin);
                weightDialog.setOnClickListener(new EditValueDialog.OnClickListener() {
                    @Override
                    public void onClick(View view, String o) {
                        goodsWeight = o;
                        weightItem.setRightText(o);
                    }
                });
                weightDialog.show();
                break;
            case 1://物品价值
                EditValueDialog valueDialog = new EditValueDialog(this);
                valueDialog.setTitle(R.string.googds_value);
                valueDialog.setEditHint(R.string.hint_input_value);
                valueDialog.setOnClickListener(new EditValueDialog.OnClickListener() {
                    @Override
                    public void onClick(View view, String o) {
                        goodsValue = o;
                        valueItem.setRightText(o);
                    }
                });
                valueDialog.show();
                break;
            case 2://配送工具
                DistributionToolsDialog distributionToolsDialog = new DistributionToolsDialog(this);
                distributionToolsDialog.setOnClickListener(new DistributionToolsDialog.OnClickListener() {
                    @Override
                    public void onClick(View view, String s) {
                        toolItem.setRightText(s);
                    }
                });
                distributionToolsDialog.show();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        getTakePhoto().onActivityResult(requestCode, resultCode, data);
    }

//    @Override
//    public void takeSuccess(TResult result) {
//        String iconPath = result.getImage().getOriginalPath();
//        mNinePhotoView.addPhoto(new File(iconPath));
//    }
//
//    @Override
//    public void takeFail(TResult result, String msg) {
//        Toast.makeText(GoodsInfoActivity.this, "Error:" + msg, Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void takeCancel() {
//
//    }
//
//    @Override
//    public PermissionManager.TPermissionType invoke(InvokeParam invokeParam) {
//        PermissionManager.TPermissionType type=PermissionManager.checkPermission(TContextWrap.of(this),invokeParam.getMethod());
//        if(PermissionManager.TPermissionType.WAIT.equals(type)){
//            this.invokeParam = invokeParam;
//        }
//        return type;
//    }
//
//    /**
//     *  获取TakePhoto实例
//     * @return
//     */
//    public TakePhoto getTakePhoto(){
//        if (takePhoto==null){
//            takePhoto= (TakePhoto) TakePhotoInvocationHandler.of(this).bind(new TakePhotoImpl(this,this));
//        }
//        return takePhoto;
//    }
}
