/*
 * @ClassName MenuDO
 * @Description 
 * @version 1.0
 * @Date 2020-06-23 18:00:19
 */
package com.cmpay.xgf.entity;

import com.cmpay.lemon.framework.annotation.DataObject;

@DataObject
public class MenuDO extends BaseDO {
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
    private String parentId;
    /**
     * @Fields operate 
     */
    private String operate;

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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }
}