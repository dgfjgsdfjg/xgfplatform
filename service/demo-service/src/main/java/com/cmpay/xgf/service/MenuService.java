package com.cmpay.xgf.service;

import com.cmpay.xgf.entity.MenuDO;
import com.cmpay.xgf.entity.RoleMenuDO;

/**
 *
 * @author xgf
 */
public interface MenuService {
    /**
     * 新增菜单
     * @param menuDO
     * @return
     */
    void createMenu(MenuDO menuDO);

    /**
     * 删除菜单
     * @param menuDO
     * @return
     * 描述
     */
    void delete(MenuDO menuDO);

    /**
     * 选择绑定菜单
     * @param roleMenuDO
     * @return
     * 描述
     */
    void checkMenu(RoleMenuDO roleMenuDO);
}
