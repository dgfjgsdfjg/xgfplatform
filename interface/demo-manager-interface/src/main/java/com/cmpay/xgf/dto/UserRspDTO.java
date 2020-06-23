/*
 * @ClassName UserDO
 * @Description 
 * @version 1.0
 * @Date 2020-06-22 10:45:11
 */
package com.cmpay.xgf.dto;

import com.cmpay.lemon.framework.annotation.DataObject;

/**
 * return UserDO
 */
@DataObject
public class UserRspDTO {
    /**
     * @Fields uId
     */
//    @GeneratedValue(key="USER_ID")
    private Integer uId;
    /**
     * @Fields userName
     */
    private String userName;
    /**
     * @Fields password
     */
    private String password;
    /**
     * @Fields email
     */
    private String email;
    /**
     * @Fields status
     */
    private String status;
    /**
     * @Fields phone
     */
    private String phone;
    /**
     * @Fields createBy
     */
    private String createBy;
    /**
     * @Fields createDate
     */
    private String createDate;
    /**
     * @Fields updateBy
     */
    private String updateBy;
    /**
     * @Fields updateDate
     */
    private String updateDate;
    /**
     * @Fields isUsed
     */
    private String isUsed;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed;
    }

}