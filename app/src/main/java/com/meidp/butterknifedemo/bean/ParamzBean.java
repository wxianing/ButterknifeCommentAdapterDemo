package com.meidp.butterknifedemo.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Package com.meidp.butterknifedemo.bean
 * 作  用:
 * Author: wxianing
 * 时  间: 16/9/24
 */

public class ParamzBean implements Serializable {
    private int PageIndex;
    private int PageSize;
    private int TotalCount;
    private int TotalPage;
    /**
     * id : 299021
     * oid : 288305
     * category : article
     * data : {"subject":"昆凌疑准备生二胎向往水中生产","summary":"近日，昆凌积极收集\u201c水中生产\u201d的情报，疑似在为生二胎做打算。","cover":"/Attachs/Article/288305/aec930dc9d8f4286a7dac65fcc96a819_padmini.JPG","pic":"","format":"txt","changed":"2015-09-19 17:22:22"}
     */

    private List<FeedsBean> feeds;

    public int getPageIndex() {
        return PageIndex;
    }

    public void setPageIndex(int PageIndex) {
        this.PageIndex = PageIndex;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int PageSize) {
        this.PageSize = PageSize;
    }

    public int getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(int TotalCount) {
        this.TotalCount = TotalCount;
    }

    public int getTotalPage() {
        return TotalPage;
    }

    public void setTotalPage(int TotalPage) {
        this.TotalPage = TotalPage;
    }

    public List<FeedsBean> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<FeedsBean> feeds) {
        this.feeds = feeds;
    }

}
