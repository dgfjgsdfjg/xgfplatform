/*
 * @ClassName UserRoleDO
 * @Description 
 * @version 1.0
 * @Date 2020-06-28 00:02:47
 */
package com.cmpay.xgf.entity;

import com.cmpay.lemon.framework.annotation.DataObject;

@DataObject
public class UserRoleDO extends BaseDO {
    /**
     * @Fields id 
     */
    private Integer id;
    /**
     * @Fields uId 
     */
    private Integer uId;
    /**
     * @Fields roleId 
     */
    private Integer roleId;
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
    private Integer isUsed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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