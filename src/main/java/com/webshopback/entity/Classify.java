package com.webshopback.entity;/**
 * @Auther: zhou
 * @Date: 2018/12/4 18:03
 * @Description:
 */

/**
 *@ClassName Classify
 *@Description 商品类目
 *@Author zhou
 *Date 2018/12/4 18:03
 *@Version 1.0
 **/
public class Classify {

    /**classifyId*/
    private int classifyId;
    /**类目名称*/
    private String classifyName;
    /**类目状态*/
    private boolean status;

    public Classify() {
    }

    public Classify(int classifyId, String classifyName, boolean status) {
        this.classifyId = classifyId;
        this.classifyName = classifyName;
        this.status = status;
    }

    public int getclassifyId() {
        return classifyId;
    }

    public void setclassifyId(int id) {
        this.classifyId = classifyId;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Classify{" +
                "classifyId=" + classifyId +
                ", classifyName='" + classifyName + '\'' +
                ", status=" + status +
                '}';
    }
}
