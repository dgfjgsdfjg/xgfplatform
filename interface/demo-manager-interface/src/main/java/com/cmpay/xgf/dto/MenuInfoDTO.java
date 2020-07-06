package com.cmpay.xgf.dto;

public class MenuInfoDTO {
    /**
     * @Fields menuId
     */
    private Integer menuId;
    /**
     * @Fields menuName
     */
    private String menuName;
    /**
     * @Fields parentId
     */
    private Integer parentId;
    /**
     * @Fields operate
     */
    private String operate;
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
    /**
     * @Fields type
     */
    private Integer type;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
