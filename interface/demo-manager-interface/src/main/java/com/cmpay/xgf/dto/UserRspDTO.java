/*
 * @ClassName UserDO
 * @Description 
 * @version 1.0
 * @Date 2020-06-22 10:45:11
 */
package com.cmpay.xgf.dto;

import com.cmpay.lemon.framework.annotation.DataObject;

import java.util.List;

/**
 * return UserDO
 */
@DataObject
public class UserRspDTO {
    /**
     * @Fields uId 用户id
     */
    private Integer uId;
    /**
     * @Fields name 用户id
     */
    private String name;
    /**
     * @Fields userName 用户名
     */
    private String userName;
    /**
     * @Fields password 用户姓名
     */
    private String password;
    /**
     * @Fields email 邮箱
     */
    private String email;
    /**
     * @Fields status 用户登陆状态
     */
    private Integer status;
    /**
     * @Fields phone 用户电话号码
     */
    private String phone;
    /**
     *  @Fields ridList 角色id列表
     */
    private List<Integer> ridList;
    /**
     * @Fields createBy 创建者
     */
    private String createBy;
    /**
     * @Fields createDate 创建日期
     */
    private String createDate;
    /**
     * @Fields updateBy 更新者
     */
    private String updateBy;
    /**
     * @Fields updateDate 更新日期
     */
    private String updateDate;
    /**
     * @Fields isUsed 是否被调用
     */
    private Integer isUsed;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Integer> getRidList() {
        return ridList;
    }

    public void setRidList(List<Integer> ridList) {
        this.ridList = ridList;
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

    public Integer getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Integer isUsed) {
        this.isUsed = isUsed;
    }

}