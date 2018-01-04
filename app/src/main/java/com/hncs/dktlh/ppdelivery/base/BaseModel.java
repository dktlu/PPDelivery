package com.hncs.dktlh.ppdelivery.base;

import android.text.TextUtils;
import android.util.Log;

import com.hncs.dktlh.ppdelivery.model.DktApi;

import java.util.HashMap;
import java.util.Map;

import cn.share.jack.cyghttp.BaseRetrofit;

/**
 * Created by dengkaitao on 2017/12/21 16:43.
 * Email：724279138@qq.com
 */

public class BaseModel extends BaseRetrofit {

    private static final String TAG = "BaseModel";

    protected DktApi mServletApi;

    protected Map<String, String> mParams = new HashMap<>();

    public BaseModel() {
        super();
        mServletApi = mRetrofit.create(DktApi.class);
    }

    @Override
    protected Map<String, String> getCommonMap() {
        Map<String, String> commonMap = new HashMap<>();
//        commonMap.put("user_id", String.valueOf(UserDao.getInstance().getUserId()));
//        commonMap.put("token", String.valueOf(UserDao.getInstance().getToken()));
        return commonMap;
    }

    protected void addParams(String key, String value) {
        if (TextUtils.isEmpty(key)) {
            Log.e(TAG, "the key is null");
            return;
        }
        mParams.put(key, value);
    }

    protected void addParams(Map<String, String> params) {
        if (null == params) {
            Log.e(TAG, "the map is null");
            return;
        }
        mParams.putAll(params);
    }
}
