/*
 * @ClassName UserDO
 * @Description 
 * @version 1.0
 * @Date 2020-06-22 10:45:11
 */
package com.cmpay.xgf.bo;

import com.cmpay.lemon.framework.annotation.DataObject;

/**
 * @author xgf
 * return UserDO
 */
@DataObject
public class UserLoginBO {
    /**
     * 用户id
     * @Fields uId
     * 描述
     */
    private Integer uId;
    /**
     * @Fields userName 
     */
    private String username;
    /**
     * @Fields password 
     */
    private String password;
    /**
     * @Fields phone 
     */
    private String phone;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserLoginBO{" +
                "uId=" + uId +
                ", userName='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}