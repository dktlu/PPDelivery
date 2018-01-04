package com.hncs.dktlh.ppdelivery.ui.custom;

import java.io.Serializable;

/**
 * Created by dengkaitao on 2017/12/27 14:28.
 * Email：724279138@qq.com
 */

public class Pickers implements Serializable {

    private static final long serialVersionUID = 1L;

    private String showContent;
    private String showId;

    public String getShowContent() {
        return showContent;
    }

    public void setShowContent(String showContent) {
        this.showContent = showContent;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public Pickers(String showContent, String showId) {
        super();
        this.showContent = showContent;
        this.showId = showId;
    }

    public Pickers() {
        super();
    }
}
