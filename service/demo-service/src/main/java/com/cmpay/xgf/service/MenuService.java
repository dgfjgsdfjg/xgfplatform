package com.cmpay.xgf.service;

import com.cmpay.xgf.dto.MenuInfoDTO;
import com.cmpay.xgf.entity.MenuDO;
import com.cmpay.xgf.entity.RoleMenuDO;

import java.util.List;
import java.util.Map;

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
     * 查找菜单
     * @param menuDO
     * @return List<MenuDO>
     * 描述
     */
    List<MenuDO> find(MenuDO menuDO);

    /**
     * 选择绑定菜单
     * @param roleMenuDO
     * @return
     * 描述
     */
    void checkMenu(RoleMenuDO roleMenuDO);

    /**
     * 查找全部菜单
     * @return
     */
    List selectAllMenu();


    /**
     * 创建树形菜单
     * @param menuList
     * @param parentId
     * @return
     */
    List<Map> buildMenu(List<MenuInfoDTO> menuList, Integer parentId);
}
