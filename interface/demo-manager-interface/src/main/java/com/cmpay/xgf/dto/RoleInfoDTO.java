package com.cmpay.xgf.dto;

public class RoleInfoDTO {

    /**
     * @Fields roleId
     */
    private Integer roleId;
    /**
     * @Fields roleName
     */
    private String roleName;

    /**
     * @Fields createTime
     */
    private String createDate;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
