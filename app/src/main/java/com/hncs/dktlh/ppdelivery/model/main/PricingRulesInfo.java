package com.hncs.dktlh.ppdelivery.model.main;

import java.util.List;

/**
 * Created by dengkaitao on 2017/12/23 17:03.
 * Email：724279138@qq.com
 */

public class PricingRulesInfo {

    private String type;
    private List<ChargeDetailInfo> mChargeDetailInfos;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ChargeDetailInfo> getChargeDetailInfos() {
        return mChargeDetailInfos;
    }

    public void setChargeDetailInfos(List<ChargeDetailInfo> chargeDetailInfos) {
        mChargeDetailInfos = chargeDetailInfos;
    }
}
