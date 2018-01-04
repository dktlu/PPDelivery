package com.hncs.dktlh.ppdelivery.ui.dialog;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.hncs.dktlh.ppdelivery.R;
import com.hncs.dktlh.ppdelivery.base.BaseActivity;
import com.hncs.dktlh.ppdelivery.utils.FileUtils;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;

import static com.hncs.dktlh.ppdelivery.Constants.RESULT_LOAD_IMAGE;


/**
 * 选择 拍照/相册 dialog
 * Created by dengkaitao on 2017/12/30 10:24.
 * Email：724279138@qq.com
 */

public class SelectPhotoDialog extends BaseDialog {

    private Context mContext;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;

    public SelectPhotoDialog(@NonNull Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    protected int layoutRes() {
        return R.layout.dialog_select_photo;
    }

    @Override
    protected void initView() {

    }

    @OnClick({R.id.tv_cancel, R.id.tv_camera, R.id.tv_album})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel:
                dismiss();
                break;
            case R.id.tv_camera://拍照
//                takeCamera(RESULT_CAMERA_IMAGE);
                dismiss();
                break;
            case R.id.tv_album://相册
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                ((BaseActivity) mContext).startActivityForResult(i, RESULT_LOAD_IMAGE);
                dismiss();
                break;
        }
    }

    /**
     * 拍照
     * @param num
     */
    private void takeCamera(int num) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(mContext.getPackageManager()) != null) {
            File photoFile = FileUtils.createImageFile();
            if (photoFile != null) {
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
            }
        }
        ((BaseActivity) mContext).startActivityForResult(takePictureIntent, num);
    }
}
