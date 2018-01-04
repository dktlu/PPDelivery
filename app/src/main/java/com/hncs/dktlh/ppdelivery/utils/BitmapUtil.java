package com.hncs.dktlh.ppdelivery.utils;

import android.graphics.Bitmap;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by dengkaitao on 2017/12/30 10:54.
 * Email：724279138@qq.com
 */

public class BitmapUtil {

    /**
     * 将bitmap转化为png格式
     * @param mBitmap
     * @return
     */
    public File saveMyBitmap(Bitmap mBitmap){
        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        File file = null;
        try {
            file = File.createTempFile(
                    FileUtils.generateFileName(),  /* prefix */
                    ".jpg",         /* suffix */
                    storageDir      /* directory */
            );

            FileOutputStream out=new FileOutputStream(file);
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 20, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  file;
    }
}
