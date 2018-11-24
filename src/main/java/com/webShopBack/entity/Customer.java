package com.webShopBack.entity;/**
 * @Auther: bee
 * @Date: 2018/11/24 16:27
 * @Description:
 */

/**
 *@ClassName Customer
 *@Description TODO
 *@Author zhou
 *Date 2018/11/24 16:27
 *@Version 1.0
 **/
public class Customer {

    //会员id
    private int customerId;
    //会员昵称
    private String nickName;
    //密码
    private String password;
    //电话
    private String phone;
    //邮箱
    private String email;
    //地址
    private String address;

    public Customer() {
    }

    public Customer(int customerId, String nickName, String password, String phone, String email, String address) {
        this.customerId = customerId;
        this.nickName = nickName;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
