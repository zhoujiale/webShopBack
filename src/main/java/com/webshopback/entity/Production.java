package com.webshopback.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 *@ClassName Production
 *@Description 商品类
 *@Author zhou
 *Date 2018/12/4 17:30
 *@Version 1.0
 **/
public class Production {

    /**商品编号*/
    private int productionId;
    /**父类目*/
    private int mainClassify;
    /**子类目*/
    private int subClassify;
    /**商品名称*/
    private String productionName;
    /**商品标题*/
    private String title;
    /**商品主图片*/
    private String mainImgUrl;
    /**商品原价*/
    private BigDecimal oldPrice;
    /**商品现价*/
    private BigDecimal newPrice;
    /**商品库存*/
    private int stack;
    /**商品状态*/
    private boolean status;
    /**创建时间*/
    private Date createTime;
    /**更新时间*/
    private Date updateTime;

    public Production() {

    }

    public Production(int productionId, int mainClassify, int subClassify, String productionName, String title,
                      String mainImgUrl, BigDecimal oldPrice, BigDecimal newPrice, int stack, boolean status,
                      Date createTime, Date updateTime) {
        this.productionId = productionId;
        this.mainClassify = mainClassify;
        this.subClassify = subClassify;
        this.productionName = productionName;
        this.title = title;
        this.mainImgUrl = mainImgUrl;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.stack = stack;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public int getProductionId() {
        return productionId;
    }

    public void setProductionId(int productionId) {
        this.productionId = productionId;
    }

    public int getSubClassify() {
        return subClassify;
    }

    public void setSubClassify(int subClassify) {
        this.subClassify = subClassify;
    }

    public String getProductionName() {
        return productionName;
    }

    public void setProductionName(String productionName) {
        this.productionName = productionName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMainImgUrl() {
        return mainImgUrl;
    }

    public void setMainImgUrl(String mainImgUrl) {
        this.mainImgUrl = mainImgUrl;
    }

    public BigDecimal getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(BigDecimal oldPrice) {
        this.oldPrice = oldPrice;
    }

    public BigDecimal getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(BigDecimal newPrice) {
        this.newPrice = newPrice;
    }

    public int getStack() {
        return stack;
    }

    public void setStack(int stack) {
        this.stack = stack;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getMainClassify() {
        return mainClassify;
    }

    public void setMainClassify(int mainClassify) {
        this.mainClassify = mainClassify;
    }

    @Override
    public String toString() {
        return "Production{" +
                "productionId=" + productionId +
                ", mainClassify=" + mainClassify +
                ", subClassify=" + subClassify +
                ", productionName='" + productionName + '\'' +
                ", title='" + title + '\'' +
                ", mainImgUrl='" + mainImgUrl + '\'' +
                ", oldPrice=" + oldPrice +
                ", newPrice=" + newPrice +
                ", stack=" + stack +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
