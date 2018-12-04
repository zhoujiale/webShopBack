package com.webShopBack.entity;/**
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

    //id
    private int id;
    //类目编号
    private String classify;
    //类目名称
    private String classifyName;
    //类目状态
    private boolean status;

    public Classify() {
    }

    public Classify(int id, String classify, String classifyName, boolean status) {
        this.id = id;
        this.classify = classify;
        this.classifyName = classifyName;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
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
}
