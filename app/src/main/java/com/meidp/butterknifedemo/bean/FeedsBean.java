package com.meidp.butterknifedemo.bean;

/**
 * Package com.meidp.butterknifedemo.bean
 * 作  用:
 * Author: wxianing
 * 时  间: 16/9/24
 */

public class FeedsBean {

    /**
     * id : 299021
     * oid : 288305
     * category : article
     * data : {"subject":"昆凌疑准备生二胎向往水中生产","summary":"近日，昆凌积极收集\u201c水中生产\u201d的情报，疑似在为生二胎做打算。","cover":"/Attachs/Article/288305/aec930dc9d8f4286a7dac65fcc96a819_padmini.JPG","pic":"","format":"txt","changed":"2015-09-19 17:22:22"}
     */

    private int id;
    private int oid;
    private String category;
    /**
     * subject : 昆凌疑准备生二胎向往水中生产
     * summary : 近日，昆凌积极收集“水中生产”的情报，疑似在为生二胎做打算。
     * cover : /Attachs/Article/288305/aec930dc9d8f4286a7dac65fcc96a819_padmini.JPG
     * pic :
     * format : txt
     * changed : 2015-09-19 17:22:22
     */

    private DataBean data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }
}
