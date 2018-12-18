package com.webShopBack.entity;/**
 * @Auther: zhou
 * @Date: 2018/12/8 17:43
 * @Description:
 */

import java.io.Serializable;

/**
 *@ClassName SubClassify
 *@Description 子类目
 *@Author zhou
 *Date 2018/12/8 17:43
 *@Version 1.0
 **/
public class SubClassify implements Serializable{
    /**子类目id*/
    public int subClassifyId;
    /**子类目名称*/
    public String subClassifyName;
    /**状态*/
    public boolean status;
    /**主类目*/
    public int mainClassifyId;

    public SubClassify() {
    }

    public SubClassify(int subClassifyId, String subClassifyName, boolean status, int mainClassifyId) {
        this.subClassifyId = subClassifyId;
        this.subClassifyName = subClassifyName;
        this.status = status;
        this.mainClassifyId = mainClassifyId;
    }

    public int getSubClassifyId() {
        return subClassifyId;
    }

    public void setSubClassifyId(int subClassifyId) {
        this.subClassifyId = subClassifyId;
    }

    public String getSubClassifyName() {
        return subClassifyName;
    }

    public void setSubClassifyName(String subClassifyName) {
        this.subClassifyName = subClassifyName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getMainClassifyId() {
        return mainClassifyId;
    }

    public void setMainClassifyId(int mainClassifyId) {
        this.mainClassifyId = mainClassifyId;
    }

    @Override
    public String toString() {
        return "SubClassify{" +
                "subClassifyId=" + subClassifyId +
                ", subClassifyName='" + subClassifyName + '\'' +
                ", status=" + status +
                ", mainClassifyId=" + mainClassifyId +
                '}';
    }
}
